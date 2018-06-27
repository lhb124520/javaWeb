 function showErrMsg($obj, msg) {		
        if($obj.next() != "undefined") {
        	
          $obj.next().remove();
        }
        var $newErrMsg = $("<span></span>");
        $newErrMsg.html("<font color='red'>" + msg + "</font>");
        //      $obj.after($newErrMsg);
        $obj.after($newErrMsg);
        
      }
      function test() {    	 
        	  var userName=$("#username").val();  
              var userPwd=$("#password").val();           
              var user={UserName:userName,PassWord:userPwd};  
              var url="Myservlet.do";  
              $.post(url, JSON.stringify(user), function(data) {  
                    console.log(data);  
                   //$("#messageDiv").html(data);  
                   var json=JSON.parse(data);  
                   alert(data);
                   alert(json.message);
                   if(json.success=="true"){
                  	 //1.我们可以利用http的重定向来跳转
                  	 //window.location.replace("http://www.jb51.net");

                  	 //2.使用href来跳转
                  	 //window.location.href = "http://www.jb51.net";

                  	 //3.使用jQuery的属性替换方法
                  	  $(location).attr('href', 'http://www.baidu.com');
                  	 //$(window).attr('location','http://www.jb51.net');
                  	 //$(location).prop('href', 'http://www.jb51.net')
                   }
               });
      }
      function test1() {
    	  var userName=$("#username").val();  
          var userPwd=$("#password").val();           
          var user={UserName:userName,PassWord:userPwd};  
          var url="Myservlet.do";  
          $.post(url, JSON.stringify(user), function(data) {  
                console.log(data);
               var json=JSON.parse(data);  
               alert(data);
               alert(json.message);
               if (navigator.userAgent.toLowerCase().match(/(android)/)) { 
        			 MyObject.showDialog("这是安卓"); 
        			 MyObject.showDialog(data); 
        			 MyObject.showDialog(json.message); 
        			 if(json.success=="true"){
        				 $(location).attr('href', '/android');
                       }
        		} else { 
        			alert("这是网页");
        		} 
           });
  		
  	       // ios 
//  		if (navigator.userAgent.toLowerCase().match(/(iphone|ipod|ipad)/)) { 
//  		iOS = true; 
//  		$('html').addClass('ios'); 
//  		userType.iOS = true; 
//  		} else { 
//  		iOS = false; 
//  		} 
  		
  	// Wechat 
//  		if (navigator.userAgent.toLowerCase().match(/micromessenger/)) { 
//  		isWechat = true; 
//  		userType.isWechat = true; 
//  		$('html').addClass('wechat'); 
//  		} else { 
//  		isWechat = false; 
//  		}
    	 
      }    
      function test2() {
//    	    $.ajax({  
//    	    	method : "post",  
//                url : "http://192.168.8.35:80/api/BDS//GetWhenNotLoginedIn", 
//                processData: false,  
//                contentType : "application/json;charset=utf-8", //这个是发送信息至服务器时内容编码类型    
//                data: {
//                	UserID:"",
//                	list:["1","1","LoginNoCom","android_dbs","869775012153232",
//                          "http:\/\/192.168.8.35:80","BDS","1.62",""],
//                    label:"User_UserLoginNoCompanyID",
//                    APIKey:"android_dbs",
//                    CompanyID:"",SessionKey:""},
//                dataType : "json",                
//                success:function(msg) {
//                	 alert("aaaaaaaa");      
//                	alert(msg);
//                	var json=JSON.parse(msg); 
//                	alert(json);                 	
//                }  
//            });
    	    var params={UserID:"",list:["1","1","HK","android_dbs","869775012153232",
                                        "http:\/\/192.168.8.35:80","BDS","1.62"],
                                        label:"User_UserLoginWithCompanyID",APIKey:"android_dbs",
                                        CompanyID:"",SessionKey:""};
    	    var url1="http://192.168.8.35:80/api/BDS//GetWhenNotLoginedIn";
    	    var data1={url:url1,params:params}; 
    	    var url="BdsServlet";
    	    $.post(url,JSON.stringify(data1), function(data) {  
               console.log(data);
               
               var json=JSON.parse(data);  
               alert("aaaaaaaaaaaaaaa");
               alert(data);
               alert(json.result);
           });
      }
      function check() {
        var errCode = 0; //如果有任何一个错误的时候，将错误代码增加1
        var firstNameVal = $("#username").val();
        var userPassVal = $("#password").val();
       
    
        if(firstNameVal == "") {
          showErrMsg($("#username"), "名字不能为空！");
         
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
       
        if(errCode > 0) {        	
          return false;
        } else {        	
          return true;
        }
     
      }

      $(function() {
        $("#userID").blur(check);
        $("#username").blur(check);
        $("#password").blur(check);	
    	
        $("#userinfo").submit(check);
        $("#button").click(test);
        $("#button1").click(test1);
        
        $("#button2").click(test2);
      });