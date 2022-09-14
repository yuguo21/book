function searchByName(name, callback, parm){
    $.ajax({
        url:"/logic/meta/list?name="+name,
        method:"post",
        async:false,
        success:function (data){
            callback(data.rows,parm);
        }
    });
}