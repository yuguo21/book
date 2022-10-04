
var counter=0;
$(window).scroll(function (e) {
    if ($(window).scrollTop()+$(window).height()>=$(document).height()-20){
        queryMeta();
    }
});