
var prefix = ctx + "logic/title";

$(function() {
    hotkeys('alt+[', function (event, handler){editContent();});

    let pageHeight = $(document.body).height();
    var panehHidden = false;
    if ($(this).width() < 769) {
        panehHidden = true;
    }

    $('body').layout({ initClosed: panehHidden, west__size: 185 });
    // 回到顶部绑定

    if ($.fn.toTop !== undefined) {
        var opt = {
            win:$('.ui-layout-center'),
            doc:$('.ui-layout-center')
        };
        $('#scroll-up').toTop(opt);
    }
    queryTree();
    initTextAreaTab(document.getElementById("content"), 4, function(key){
        if (key === 'KeyS'){
            saveContent();
        }else if (key === 'KeyE'){
            editContent();
        }else if (key === 'KeyL'){
            let contentLength = document.getElementById("content").value;
            contentLength = contentLength.replace(" ","");
            $.modal.msgSuccess("字："+contentLength.length+"个");
        }else if (key === 'KeyM'){
            addCard();
        }
    });
    document.querySelector("#btnRefresh").onclick = queryTree;
    document.querySelector("#btnAddTitle").onclick = openAddTitle;
});
//chapter tree
function queryTree() {
    var url = prefix + "/tree?bookKey=" + bookKey;
    var options = {
        url: url,
        expandLevel: 2,
        onClick : zOnClick
    };
    $.tree.init(options);

    function zOnClick(event, treeId, treeNode) {
        let nodeId = treeNode.id;
        if (nodeId != '99999999'){
            $("#titleId").val(nodeId);
            getContentByTitileId(nodeId);
        }else{
            $("#titleId").val('');
        }
    }
}

function getContentByTitileId(id){
    //点击章节获取对应的内容
    $.ajax({
        url: prefix + "/getContent",
        method: "get",
        data: {titleId: id},
        success: function(data){
            if (data.code == 0){
                try{
                    if (data.data.content){
                        $("#content").val(data.data.content);
                        $("#content").attr("readonly", true);
                    }else{
                        $("#content").val("");
                    }
                }catch (e) {
                    $("#content").val("");
                    $("#content").attr("readonly", false);                        }
            }
        }
    });
}

function saveContent(flag){
    let bookContent = $("#bookForm").serialize();
    $.ajax({
        url: prefix + "/addContent",
        method: "post",
        data: bookContent,
        success: function(data){
            if(data.code == 0){
                $.modal.msgSuccess(data.msg);
            }
        }
    });
}

function editContent(){
    $.modal.loading("编辑模式");
    let readonlyflag = $("#content").attr("readonly");
    if (readonlyflag){
        $("#content").attr("readonly", false);
    }else{
        $("#content").attr("readonly", true);
    }
    setTimeout(function(){
        $.modal.closeLoading();
    }, 500)
}

function openEditTitle(){
    let titleId = $("#titleId").val();
    if (titleId != '999999999' && titleId != ''){
        $.modal.open("修改", prefix + "/edit/"+titleId, 800, 200, editTitleCallBack);
    }
}

function openAddTitle(){
    let bookKey = $("#bookKey").val();
    $.modal.open("修改", prefix + "/add?bookKey="+bookKey, 800, 200, addTitleCallBack);

}

function addTitleCallBack(index){
    let retVal = window.parent.document.querySelector("#layui-layer-iframe"+index).contentWindow.submitHandler();
    if (retVal){
        setTimeout(function (){
            queryTree();
        }, 800);
        $.modal.closeAll();
    }
}

function editTitleCallBack(index){
    window.parent.document.querySelector("#layui-layer-iframe"+index).contentWindow.submitHandler();
    setTimeout(function (){
        queryTree();
    }, 800);
    $.modal.closeAll();
}

function saveTmpContent(){
    //文本保存至本地
}

function addCard(){
    $.modal.openTab(bookName + "::元素", ctx + "logic/meta?bookKey="+bookKey);
}


/**
 * 这个要不要呢？
 */
function openMetaWindow(){
    $.modal.open("添加元素", ctx + "logic/meta/add?bookKey="+bookKey, 800, 600, addCallBack);
}

function addCallBack(index){
    window.parent.document.querySelector("#layui-layer-iframe"+index).contentWindow.submitHandler();
    $.modal.alertSuccess("添加成功");
    $.modal.closeAll();
}