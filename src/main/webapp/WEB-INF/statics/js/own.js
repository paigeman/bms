/*
       自定义jquery函数，完成将form 数据转换为 json格式
*/
$.fn.serializeJson=function(){
    var serializeObj={};
    var array=this.serializeArray();
    // var str=this.serialize();
    $(array).each(function(){ // 遍历数组的每个元素
        if(serializeObj[this.name]){ // 判断对象中是否已经存在 name，如果存在name
            if($.isArray(serializeObj[this.name])){
                serializeObj[this.name].push(this.value);
            }else{
                serializeObj[this.name]=[serializeObj[this.name],this.value];
            }
        }else{
            serializeObj[this.name]=this.value; // 如果元素name不存在，添加一个属性 name:value
        }
    });
    return serializeObj;
};

function jump(obj) {
    var who = "";
    $.ajax({
        url:"/view/showWho",
        type:"POST",
        dataType: "text",
        async: false,
        success:function (data) {
            who = data;
        },
        error:function () {

        }
    });
    console.log($(obj).attr("name"));
    var uri;
    if($(obj).attr("name")=="first"){
        uri = "/book/queryWant";
    }
    else if($(obj).attr("name")=="before"){
        uri = "/book/queryWant?offset=" + ($(obj).attr("id") - 1);
    }
    else if($(obj).attr("name")=="next"){
        uri = "/book/queryWant?offset=" + ((Number)($(obj).attr("id")) + 1);
        console.log($(obj).attr("id"));
        console.log(uri);
    }
    else if($(obj).attr("name")=="end"){
        uri = "/book/queryWant?offset=" + $(obj).attr("id");
    }
    else{
        uri = "/book/queryWant?offset=" + $(obj).attr("id");
    }
    console.log($(obj).parent().parent().prev().children().children().children().next());
    console.log($(obj).parent().parent().parent().parent().serializeJson());
    console.log($(obj).parent());
    $.ajax({
        url:uri,
        type:"POST",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        async: false,
        data:JSON.stringify($(obj).parent().parent().parent().parent().serializeJson()),
        success:function (data) {
            console.log(data);
            var tmpHTML = "";
            var tmpList = data.list;
            for(var i = 0;i<tmpList.length;i++){
                tmpHTML += "<tr>"+"<td "+((who=="admin")?"class='update-book' data-toggle='tooltip' data-placement='top' title='点击查看或更新图书详细资料'":"")+">"+tmpList[i].book_No+"</td>"+"<td>"+tmpList[i].book_name+"</td>"+"<td>"+tmpList[i].book_author+"</td>"
                    +"<td>"+tmpList[i].book_publisher+"</td>"+"<td>"+tmpList[i].book_category+"</td>"+"<td>"+tmpList[i].book_price+"</td>";
                if(who=="reader"){
                    tmpHTML += "<td>"+tmpList[i].book_number+"</td>"+"<td><div class='btn-borrow' id='btn-borrow"+i+"' onclick='borrow(this)'>借书</div></td>"+"</tr>";
                }
                else if(who=="admin"){
                    tmpHTML += "<td>"+tmpList[i].book_number+"</td>"+"<td><div class='btn-borrow' id='btn-borrow"+i+"' onclick='deleteBook(this)'>删除</div></td>"+"</tr>";
                }
            }
            $(obj).parent().parent().prev().children().children().children().next().html(tmpHTML);
            var tmpNav = "<div class='bar-div' name='first' onclick='jump(this)'><span class='btn-page btn-default'>首页</span></div>";
            if(data.isFirstPage==false){
                tmpNav += "<div class='bar-div' name='before' id='"+data.pageNum+"' onclick='jump(this)'><span class='btn-page btn-default'>上一页</span></div>";
            }
            for(var i =0;i<data.navigatepageNums.length;i++){
                tmpNav += "<div class='bar-div' name='"+(data.navigatepageNums[i])+"' onclick='jump(this)' id='"+(data.navigatepageNums[i])+"'";
                if(data.pageNum==data.navigatepageNums[i]){
                    tmpNav += "><span class='btn-page btn-active'>"+(data.navigatepageNums[i])+"</span></div>";
                }
                else{
                    tmpNav += "><span class='btn-page btn-default'>"+(data.navigatepageNums[i])+"</span></div>";
                }
            }
            if(data.isLastPage==false){
                tmpNav += "<div class='bar-div' name='next' id='"+data.pageNum+"' onclick='jump(this)'><span class='btn-page btn-default'>下一页</span></div>";
            }
            tmpNav += "<div class='bar-div' name='end' id='"+data.lastPage+"' onclick='jump(this)'><span class='btn-page btn-default'>尾页</span></div>";
            // if(who=="admin"){
            //     tmpNav += "<div class='bar-div' id='add-book'><span class='btn-page btn-info'>上架新书</span></div>"
            // }
            $("#nav-bar").html(tmpNav);
        },
        error:function () {
            console.log("jump error!");
        }
    });
}

function jp(obj) {
    var uri = "";
    if($(obj).attr("name")=="first"){
        uri = "/record/queryWant";
    }
    else if($(obj).attr("name")=="before"){
        uri = "/record/queryWant?offset=" + ($(obj).attr("id") - 1);
    }
    else if($(obj).attr("name")=="next"){
        uri = "/record/queryWant?offset=" + ((Number)($(obj).attr("id")) + 1);
        console.log($(obj).attr("id"));
        console.log(uri);
    }
    else if($(obj).attr("name")=="end"){
        uri = "/record/queryWant?offset=" + $(obj).attr("id");
    }
    else{
        uri = "/record/queryWant?offset=" + $(obj).attr("id");
    }
    // console.log($(obj).parent().parent().parent().parent());
    // console.log(uri);
    $.ajax({
       url:uri,
        type:"POST",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        async: false,
        data:JSON.stringify($(obj).parent().parent().parent().parent().serializeJson()),
        success:function (data) {
           // console.log($(obj).parent().parent().prev().children().children().children().next());
            var tbody = "";
            var tmpList = data.list;
            for(var i= 0;i<tmpList.length;i++){
                tbody += "<tr><td>"+tmpList[i].record_id+"</td><td>"+tmpList[i].record_book+"</td>" + "<td>"+tmpList[i].record_reader+"</td>" +
                    "<td>"+tmpList[i].record_admin+"</td><td>"+tmpList[i].record_borrow+"</td><td>"+((tmpList[i].record_return==null)?((tmpList[i].record_is_lost==1)?"已挂失":"尚未归还"):((tmpList[i].record_is_lost==1)?"已挂失":(tmpList[i].record_return)))+"</td>" +
                    "<td>";
                if(tmpList[i].record_is_return==1){
                    // tbody += "<div class='admin-do' id='book-return'>归还</div><div class='admin-do' id='book-lost'>挂失</div>"
                    tbody += "<div class='admin-do' id='record-delete' onclick='record_delete(this)'>删除</div></td></tr>";
                }
                else if(tmpList[i].record_is_lost==1) {
                    tbody += "<div class='admin-do' id='record-delete' onclick='record_delete(this)'>删除</div></td></tr>";
                }
                else{
                    tbody += "<div class='admin-do' id='book-return' onclick='book_return(this)'>归还</div><div class='admin-do' id='book-lost' onclick='book_lost(this)'>挂失</div></td></tr>";
                }
            }
            $(obj).parent().parent().prev().children().children().children().next().html(tbody);
            var tmpNav = "<div class='bar-div' name='first' onclick='jp(this)'><span class='btn-page btn-default'>首页</span></div>";
            if(data.isFirstPage==false){
                tmpNav += "<div class='bar-div' name='before' id='"+data.pageNum+"' onclick='jp(this)'><span class='btn-page btn-default'>上一页</span></div>";
            }
            for(var i =0;i<data.navigatepageNums.length;i++){
                tmpNav += "<div class='bar-div' name='"+(data.navigatepageNums[i])+"' onclick='jp(this)' id='"+(data.navigatepageNums[i])+"'";
                if(data.pageNum==data.navigatepageNums[i]){
                    tmpNav += "><span class='btn-page btn-active'>"+(data.navigatepageNums[i])+"</span></div>";
                }
                else{
                    tmpNav += "><span class='btn-page btn-default'>"+(data.navigatepageNums[i])+"</span></div>";
                }
            }
            if(data.isLastPage==false){
                tmpNav += "<div class='bar-div' name='next' id='"+data.pageNum+"' onclick='jp(this)'><span class='btn-page btn-default'>下一页</span></div>";
            }
            tmpNav += "<div class='bar-div' name='end' id='"+data.lastPage+"' onclick='jp(this)'><span class='btn-page btn-default'>尾页</span></div>";
            $("#nav-bar").html(tmpNav);
        },
        error:function () {
            console.log("show record error!");
        }
    });
}

function borrow(obj) {
    console.log($(obj).parent().prev().prev().prev().prev().prev().prev().prev().text());
    var book_No = $(obj).parent().prev().prev().prev().prev().prev().prev().prev().text();
    console.log(book_No);
    $.ajax({
        url: "/record/borrow",
        type:"POST",
        contentType: "application/json;charset=utf-8",
        dataType: "text",
        data:JSON.stringify({"book_No":book_No}),
        success:function (data) {
            // console.log(data);
            if(data=="true"){
                // console.log($(obj).parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent().parent())
                $("#nav-li-3",parent.document).css("background-color","#ea5455");
                $("#nav-li-3",parent.document).css("color","#fff");
                $("#nav-li-1",parent.document).css("background-color","#fff");
                $("#nav-li-1",parent.document).css("color","#626262");
                $("#nav-li-2",parent.document).css("background-color","#fff");
                $("#nav-li-2",parent.document).css("color","#626262");
                window.location.href = "/view/record";
            }
            else{
                console.log(data);
            }
        },
        error:function () {
            console.log("borrow error");
        }
    });
}

function jmp(obj) {
    var uri;
    if($(obj).attr("name")=="first"){
        uri = "/record/querySpecificReader";
    }
    else if($(obj).attr("name")=="before"){
        uri = "/record/querySpecificReader?offset=" + ($(obj).attr("id") - 1);
    }
    else if($(obj).attr("name")=="next"){
        uri = "/record/querySpecificReader?offset=" + ((Number)($(obj).attr("id")) + 1);
        console.log($(obj).attr("id"));
        console.log(uri);
    }
    else if($(obj).attr("name")=="end"){
        uri = "/record/querySpecificReader?offset=" + $(obj).attr("id");
    }
    else{
        uri = "/record/querySpecificReader?offset=" + $(obj).attr("id");
    }
    $.ajax({
        url: uri,
        type:"POST",
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        success:function (data) {
            // console.log($(obj).parent().parent().prev().children().children().children().next());
            var tbody = "";
            var tmpList = data.list;
            for(var i= 0;i<tmpList.length;i++){
                tbody += "<tr><td>"+tmpList[i].record_id+"</td><td>"+tmpList[i].record_book+"</td>" +
                    "<td>"+tmpList[i].record_admin+"</td><td>"+tmpList[i].record_borrow+"</td><td>"+((tmpList[i].record_return==null)?"尚未归还":tmpList[i].record_return)+"</td></tr>";
            }
            $(obj).parent().parent().prev().children().children().children().next().html(tbody);
            var tmpNav = "<div class='bar-div' name='first' onclick='jmp(this)'><span class='btn-page btn-default'>首页</span></div>";
            if(data.isFirstPage==false){
                tmpNav += "<div class='bar-div' name='before' id='"+data.pageNum+"' onclick='jmp(this)'><span class='btn-page btn-default'>上一页</span></div>";
            }
            for(var i =0;i<data.navigatepageNums.length;i++){
                tmpNav += "<div class='bar-div' name='"+(data.navigatepageNums[i])+"' onclick='jmp(this)' id='"+(data.navigatepageNums[i])+"'";
                if(data.pageNum==data.navigatepageNums[i]){
                    tmpNav += "><span class='btn-page btn-active'>"+(data.navigatepageNums[i])+"</span></div>";
                }
                else{
                    tmpNav += "><span class='btn-page btn-default'>"+(data.navigatepageNums[i])+"</span></div>";
                }
            }
            if(data.isLastPage==false){
                tmpNav += "<div class='bar-div' name='next' id='"+data.pageNum+"' onclick='jmp(this)'><span class='btn-page btn-default'>下一页</span></div>";
            }
            tmpNav += "<div class='bar-div' name='end' id='"+data.lastPage+"' onclick='jmp(this)'><span class='btn-page btn-default'>尾页</span></div>";
            $("#nav-bar").html(tmpNav);
        },
        error:function () {
            console.log("jmp error");
        }
    });
}

function deleteBook(obj) {
    var who = "";
    $.ajax({
        url:"/view/showWho",
        type:"POST",
        dataType: "text",
        async: false,
        success:function (data) {
            who = data;
        },
        error:function () {

        }
    });
    var book_No = $(obj).parent().prev().prev().prev().prev().prev().prev().prev().text();
    // console.log(book_No);
    $.ajax({
        url: "/book/delete",
        type:"POST",
        contentType: "application/json;charset=utf-8",
        dataType: "text",
        data:JSON.stringify({"book_No":book_No}),
        success:function (data) {
            console.log(data);
            if(data=="true"){
                $.ajax({
                    url:"/book/queryWant",
                    type:"POST",
                    contentType: "application/json;charset=utf-8",
                    dataType: "json",
                    async: false,
                    data:JSON.stringify($("#query-book-form").serializeJson()),
                    success:function (data) {
                        var tmpList = data.list;
                        var tmpHtml = "";
                        for(var i = 0;i<tmpList.length;i++){
                            tmpHtml += "<tr>"+"<td "+((who=="admin")?"class='update-book' data-toggle='tooltip' data-placement='top' title='点击查看或更新图书详细资料'":"")+">"+tmpList[i].book_No+"</td>"+"<td>"+tmpList[i].book_name+"</td>"+"<td>"+tmpList[i].book_author+"</td>"
                                +"<td>"+tmpList[i].book_publisher+"</td>"+"<td>"+tmpList[i].book_category+"</td>"+"<td>"+tmpList[i].book_price+"</td>";
                            if(who=="reader"){
                                tmpHtml += "<td>"+tmpList[i].book_number+"</td>"+"<td><div class='btn-borrow' id='btn-borrow"+i+"' onclick='borrow(this)'>借书</div></td>"+"</tr>";
                            }
                            else if(who=="admin"){
                                tmpHtml += "<td>"+tmpList[i].book_number+"</td>"+"<td><div class='btn-borrow' id='btn-borrow"+i+"' onclick='deleteBook(this)'>删除</div></td>"+"</tr>";
                            }
                        }
                        // console.log($(obj).parent().parent().parent());
                        $(obj).parent().parent().parent().html(tmpHtml);
                        // $(obj).parent().parent().prev().children().children().children().next().html(tmpHtml);
                        var nav = "<div class='bar-div' name='first' onclick='jump(this)'><span class='btn-page btn-default'>首页</span></div>";
                        if(data.isFirstPage==false){
                            nav += "<div class='bar-div' name='before' id='"+data.pageNum+"' onclick='jump(this)'><span class='btn-page btn-default'>上一页</span></div>";
                        }
                        for(var i =0;i<data.navigatepageNums.length;i++){
                            nav += "<div class='bar-div' name='"+(data.navigatepageNums[i])+"' onclick='jump(this)' id='"+(data.navigatepageNums[i])+"'";
                            if(data.pageNum==data.navigatepageNums[i]){
                                nav += "><span class='btn-page btn-active'>"+(data.navigatepageNums[i])+"</span></div>";
                            }
                            else{
                                nav += "><span class='btn-page btn-default'>"+(data.navigatepageNums[i])+"</span></div>";
                            }
                        }
                        if(data.isLastPage==false){
                            nav += "<div class='bar-div' name='next' id='"+data.pageNum+"' onclick='jump(this)'><span class='btn-page btn-default'>下一页</span></div>";
                        }
                        nav += "<div class='bar-div' name='end' id='"+data.lastPage+"' onclick='jump(this)'><span class='btn-page btn-default'>尾页</span></div>";
                        if(who=="admin"){
                            nav += "<div class='bar-div' id='add-book'><span class='btn-page btn-info'>上架新书</span></div>"
                        }
                        $("#nav-bar").html(nav);
                    },
                    error:function () {

                    }
                });
            }
            else{

            }
        },
        error:function () {
            console.log("delete error");
        }
    });
}

function queryInfo(obj) {
    var book_No = $(obj).text();
    window.location.href = "/view/info?book_No="+book_No;
}

function book_return(obj) {
    var record_id = $(obj).parent().prev().prev().prev().prev().prev().prev().text();
    $.ajax({
        url: "/record/return?record_id="+record_id,
        type:"POST",
        dataType: "text",
        async: false,
        success:function (data) {
            window.location.href = "/view/showReaderRecord";
        },
        error:function () {
            console.log("book return occur error!");
        }
    });
}

function book_lost(obj) {
    var record_id = $(obj).parent().prev().prev().prev().prev().prev().prev().text();
    $.ajax({
        url:"/record/setLost?record_id="+record_id,
        type:"POST",
        dataType: "text",
        async: false,
        success:function (data) {
            window.location.href = "/view/showReaderRecord";
        },
        error:function () {
            console.log("set book lost occur error!");
        }
    });
}

function record_delete(obj) {
    var record_id = $(obj).parent().prev().prev().prev().prev().prev().prev().text();
    $.ajax({
        url:"/record/delete?record_id="+record_id,
        type:"POST",
        dataType: "text",
        async: false,
        success:function (data) {
            window.location.href = "/view/showReaderRecord";
        },
        error:function () {
            console.log("delete record occur error!");
        }
    });
}