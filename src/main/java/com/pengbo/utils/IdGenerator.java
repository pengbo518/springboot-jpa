package com.pengbo.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * ClassName:IdGenerator <br/>
 * 
 * Function: TODO ADD FUNCTION. <br/>
 * 
 * Reason: TODO ADD REASON. <br/>
 * 
 * Date: 2018年6月25日23:03:20 <br/>
 * @author Kevin
 * 
 * @version
 * 
 * @since JDK 1.8
 * 
 * @see
 * 
 */
@Data
@Slf4j
public class IdGenerator {

	/**
	 * SnowFlake算法 64位Long类型生成唯一ID 第一位0，表明正数 2-42，41位，表示毫秒时间戳差值，起始值自定义
	 * 43-52，10位，机器编号，5位数据中心编号，5位进程编号 53-64，12位，毫秒内计数器 本机内存生成，性能高 * 主要就是三部分：
	 * 时间戳，进程id，序列号 时间戳41，id10位，序列号12位 *
	 * 
	 * @author James.
	 * @param args
	 * @since JDK 1.8
	 */

	private final long processId;
	private final long epoch = 1403854494756L; // 时间起始标记点，作为基准，一般取系统的最近时间
	private final long workerIdBits = 10L; // 机器标识位数
	private final long maxWorkerId = -1L ^ -1L << this.workerIdBits;// 机器ID最大值: 1023
	private long sequence = 0L; // 0，并发控制
	private final long sequenceBits = 12L; // 毫秒内自增位

	private final long workerIdShift = this.sequenceBits; // 12
	private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;// 22
	private final long sequenceMask = -1L ^ -1L << this.sequenceBits; // 4095,111111111111,12位
	private long lastTimestamp = -1L;

	private IdGenerator(long processId) {
		if (processId > ((1 << workerIdBits) - 1)) {

			throw new RuntimeException("进程ID超出范围，设置位数" + workerIdBits + "，最大"

					+ ((1 << workerIdBits) - 1));

		}

		this.processId = processId;
	}

	
	@SuppressWarnings("static-access")
	public synchronized long nextId() throws Exception {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) { // 如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环); 对新的timestamp，sequence从0开始
			this.sequence = this.sequence + 1 & this.sequenceMask;
			if (this.sequence == 0) {
				timestamp = this.tilNextMillis(this.lastTimestamp);// 重新生成timestamp
			}
		} else {
			this.sequence = 0;
		}

		if (timestamp < this.lastTimestamp) {
			log.error(String.format("clock moved backwards.Refusing to generate id for %d milliseconds",
					(this.lastTimestamp - timestamp)));
			throw new Exception(String.format("clock moved backwards.Refusing to generate id for %d milliseconds",
					(this.lastTimestamp - timestamp)));
		}

		this.lastTimestamp = timestamp;
		return timestamp - this.epoch << this.timestampLeftShift | this.processId << this.workerIdShift | this.sequence;
	}

	private static IdGenerator flowIdWorker = new IdGenerator(1);

	public static IdGenerator getFlowIdWorkerInstance() {
		return flowIdWorker;
	}

	/**
	 * 等待下一个毫秒的到来, 保证返回的毫秒数在参数lastTimestamp之后
	 */
	@SuppressWarnings("static-access")
	private long tilNextMillis(long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	/**
	 * 获得系统当前毫秒数
	 */
	private static long timeGen() {
		return System.currentTimeMillis();
	}


}