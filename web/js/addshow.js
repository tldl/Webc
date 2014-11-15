	var record = new Array();
    	var num;
    	<c:forEach items="${agendalist}" var="str" varStatus="vs">
    	alert("nimeia");
    	record[${vs.index}] = new Array();
   		record[${vs.index}][0] ='${str.id}';
    	record[${vs.index}][1] ='${str.title}';
    	record[${vs.index}][2] ='${str.startDate}';
    	record[${vs.index}][3] ='${str.content}';
    	if (${vs.last}) {
        	num = ${vs.index}+1};
    	}
    </c:forEach>
	var str=['Sun','Mon','Tue','Wen','Thu','Fri','Sat'];
		function init(){
			$("#index").html("");
			$("#tbody").html("");
			for(var i=0;i<num;i++){
				$('<tr id="tr_'+i+'"><td>'+(i+1)+"</td><td>"+record[i][1]+"</td><td>"+record[i][2]+"</td><td>"+'<a onclick="showcontext('+i+')"></a>'+"</td><td>"+'<form  method="post" target="noneiframe" onclick=delete_1('+i+') action=DeleteAgenda ><input type="submit" id="delete" value="" ><input type="hidden" name="id" value="'+record[i][0]+'"></form>'+"</td></tr>").appendTo("#tbody");
			}

			for(var i=0;i<num;i++){
				$('<tr><td  onclick="showcontext('+i+')" id="index'+i+'"><div id="index_'+i+'"><span >'+(i+1)+'</span></div></td></tr>').appendTo("#index");
			}

			$('<tr><td id="returns" onclick="returnschedule()"><span  >'+'返回'+'</span></td></tr>').appendTo("#index");
			var height=num*62+52;
			document.getElementById("schedule").style.height=height+"px";
			$("#context").attr("class","invisual");
			if(num==0){
					document.getElementById("schedule").style.height="200px";
					$("#norecord").html("没有任何记录~~~<br>快点添加一条吧~~~");
			}else{
				$("#norecord").html("");
			}
			$("#select1").attr("class","onfo");
			$("#select2").attr("class","inonfo");
			$("#select2").attr("onclick","addwindow()");
			$("#addnew").attr("class","invisual");
		}
		function addwindow(){
			inittime();
			$("#select1").attr("class","inonfo");
			$("#select2").attr("class","onfo");
			$("#select1").attr("onclick","showwindow()");
			$("#select2").attr("onclick","");
			$("#schedule").attr("class","invisual");
			$("#addnew").attr("class","");
			$("#context").attr("class","invisual");

		}
		function inittime(){
			var time=new Date();
			var month=time.getMonth()+1;
			var date=time.getDate();
			var day=time.getDay(); 
			var year=time.getFullYear(); 
			var hour=time.getHours();
			var min=time.getMinutes();
			document.getElementById("addda").value=year+"-"+month+"-"+date+"-"+hour+":"+min+"@"+str[day];
		}
		function showwindow(){
			$("#select1").attr("class","onfo");
			$("#select2").attr("class","inonfo");
			$("#select2").attr("onclick","addwindow()");
			$("#addnew").attr("class","invisual");
			$("#schedule").attr("class","");
		}
		function showcontext(i){

			$("#schedule").attr("class","invisual");
			$("#context").attr("class","");
			$("#text").html(record[i][3]);
			$("#title_").html(record[i][1]);
			$("#date_").html(record[i][2]);
			for(var j=0;j<num;j++){
				$("#index_"+j).attr("class","v");
			}
			$("#index_"+i).attr("class","p");
			
		}

		function delete_1(j){
			$("#main").attr("class","transparent");
			$("#hide").attr("class","");
			document.getElementById("delete_dialog").style.top=j*60+20+"px";

		}
		function delete_2(j){
			num--;
			for(var i=j;i<num;i++){
				record[i][0] = record[i + 1][0];
           	 	record[i][1] = record[i + 1][1];
            	record[i][2] = record[i + 1][2];
            	record[i][3] = record[i + 1][3];
			}
			init();
			$("#main").attr("class","");
			$("#hide").attr("class","invisual");
		}
		function delete_cancel(){
			$("#main").attr("class","");
			$("#hide").attr("class","invisual");
		}
		function returnschedule(){
			$("#schedule").attr("class","");
			$("#context").attr("class","invisual");
		}
		function addnew(){
			var titl=document.getElementById("addti").value;
			if((titl==null)||(titl=="")){
				attend();
				return false;
			}else{
				num++;
				if(num==1){
					record[num-1][0]=1;
				}else{
					record[num-1][0] = record[num-2][0];
				}
           	 	record[num-1][1] = document.getElementById("addti").value;
            	record[num-1][2] = document.getElementById("addda").value;
            	record[num-1][3] = document.getElementById("addcon").value;
				showwindow();
				init();
				return true;
			}
			
		}
		function attend(){
			$("#attend").attr("class","");
			document.getElementById("cancel").focus();
		}
		function attendinvisual(){
			$("#attend").attr("class","invisual");
			document.getElementById("addti").focus();
		}