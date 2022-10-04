
function queryRelation(){
    $.ajax({
        url: prefix + "/listAll",
        method: "post",
        data: {bookKey: bookKey, personIdA: metaId},
        beforeSend: function(){
            $.modal.loading();
        },
        success: function(data){
            let model = "<div class=\"col-sm-3 metaCol\"><div class=\"thumbnail\"><img src=\"{0}\">"
                +"<div class=\"caption\">"
                +"<h3>{1}</h3>"
                +"<div class=\"text-right\" style=\"padding-bottom: 10px;\">"
                +"<a href=\"#times\" style=\"padding-right: 10px;\" onclick=\"removeMeta({3})\" title=\"删除元素\"><i class=\"fa fa-times\"></i></a>"
                +"<a href=\"#pencil-square-o\" style=\"padding-right: 10px;\" onclick=\"editMeta({3})\" title=\"编辑元素\"><i class=\"fa fa-edit\"></i></a>"
                +"</div>"
                +"<div style=\"height: 100px;max-height: 100px;\">"
                +"<p>{2}</p>"
                +"</div></div></div></div>";
            for (let i=0; i<data.length; i++){
                let photo = data[i].photo===""?ctx + "img/qtk.jpg":data[i].photo;
                $("#relationContent").append(model.format(photo, data[i].name, data[i].remark, data[i].relationId));
            }
            $.modal.closeLoading();
        }
    })
}

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
        if (nodeId > '90000000'){

        }else{
            addRelation(treeNode);
        }
    }
}
let hiddenNodes=[]; //用于存储被隐藏的结点

//过滤ztree显示数据
function filter(obj) {
    //显示上次搜索后背隐藏的结点
    zTreeObj.showNodes(hiddenNodes);

    //查找不符合条件的叶子节点
    function filterFunc(node) {
        let _keywords = $(obj).val();
        if (node.isParent || node.name.indexOf(_keywords) != -1) return false;
        return true;
    };

    //获取不符合条件的叶子结点
    hiddenNodes = zTreeObj.getNodesByFilter(filterFunc);

    //隐藏不符合条件的叶子结点
    zTreeObj.hideNodes(hiddenNodes);
}



let currentTreeNodeId = 0;

function addRelation(treeNode){
    let nodeId = treeNode.id;
    if (currentTreeNodeId === nodeId){
        currentTreeNodeId = 0;
        $.modal.open(metaName+"::"+treeNode.name, prefix + "/add?bookKey="+bookKey+"&personIdA="+metaId+"&personIdB="+nodeId, 800, 400, addRelationCallBack);
    }else{
        currentTreeNodeId = nodeId;
    }
}

function addRelationCallBack(index){
    window.parent.document.querySelector("#layui-layer-iframe"+index).contentWindow.submitHandler();
    setTimeout(function (){
        //queryTree();
        //重新查询 关系列表
    }, 800);
    $.modal.closeAll();
}
