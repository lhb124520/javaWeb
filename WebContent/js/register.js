  function showErrMsg($obj, msg) {
	  	
        if($obj.next() != "undefined") {
        	
          $obj.next().remove();
        }
        var $newErrMsg = $("<span></span>");
        $newErrMsg.html("<font color='red'>" + msg + "</font>");
        //      $obj.after($newErrMsg);
        $obj.after($newErrMsg);
        
      }

      function check() {
        var errCode = 0; //如果有任何一个错误的时候，将错误代码增加1
        var firstNameVal = $("#username").val();
        var userPassVal = $("#password").val();
        var rePassVal = $("#repassword").val();
        var phoneVal = $("#phone").val();
        var addressVal = $("#address").val();
        var regexp3 = /^\d{11}$/;//手机号码验证
    
        if(firstNameVal == "") {
          showErrMsg($("#username"), "姓名不能为空！");
         
          errCode++;
        }
        else{
        	$("#username").next().remove();
        }
        if(userPassVal=="") {
          showErrMsg($("#password"), "密码不能为空！");
          
          errCode++;
        }else{
        	$("#password").next().remove();
        }
        if(rePassVal=="") {
          showErrMsg($("#repassword"), "确认密码不能为空！");
          
          errCode++;
        }else{
        	$("#repassword").next().remove();
        }
       if(phoneVal=="") {
          showErrMsg($("#phone"), "手机号码不能为空！");
          
          errCode++;
        }else{
        	$("#phone").next().remove();
        }
        if(addressVal=="") {
          showErrMsg($("#address"), "家庭地址不能为空！");
          
          errCode++;
        }else{
        	$("#address").next().remove();
        }
         if(userPassVal!=rePassVal) {
          showErrMsg($("#repassword"), "密码不一致！");
          
          errCode++;
        }else{
        	$("#repassword").next().remove();
        }
		if(userPassVal.length < 6) {
          showErrMsg($("#password"), "密码长度小于六位！");
          errCode++;
        }else{
        	$("#password").next().remove();
        }
		if(userPassVal.length < 6) {
          showErrMsg($("#password"), "密码长度小于六位！");
          errCode++;
        }else{
        	$("#password").next().remove();
        }
		/^\d{11}$/;//手机号码验证
		 //手机号码验证
          if(!regexp3.test($("#phone").val())) {
           showErrMsg($("#phone"), "手机号码为11位数字！");
           errCode++;
          } else {
           $("#phone").next().remove();
          }
		
        if(errCode > 0) {
          return false;
        } else {
        	
          return true;
        }
      }

      $(function() {
     
        $("#username").blur(check);
        $("#password").blur(check);
        $("#phone").blur(check);
        $("#address").blur(check);
        
        $("#form").submit(check);
       
      });