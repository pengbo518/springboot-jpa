$(function(){
    var bgArr = ["./images/bg/1.jpg","./images/bg/2.jpg","./images/bg/3.jpg"];/*将图片存放在数组中*/
    var index = 0; /*下标*/
    /*定时器*/
    setInterval(function(){
        index ++;//*index =index+1
        /*判断*/
        if(index>2){
            index = 0;
        }
        $("body").css({
            "transition":"1s all",
            "background-image":"url("+ bgArr[index] +")"
        });
    },5000);
});