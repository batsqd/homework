(function($){
    $(document).ready(function(){

        $("#btn-submit").click(function(){
            var formIsNull=true;
            for(var i=0;i<document.form1.elements.length-1;i++)
            {
                if(document.form1.elements[i].value=="")
                {
                    formIsNull=false;
                    alert("当前表单不能有空项!");
                    break;
                }
            }
           if(formIsNull){
               var form = new FormData(document.getElementById("commodityForm"));
               //alert(form);
               $.ajax({
                   url: 'http://localhost:8080/homework/uploadCommodityData.action',
                   type: 'post',
                   data:form,
                   processData:false,
                   contentType:false,
                   async: false,
                   success : function(data){
                       if(data.sucess!=null){
                           alert("操作成功！");
                       }else{
                           alert(data.fail);
                       }

                   }

               });
           }

        });
  });
})(jQuery);