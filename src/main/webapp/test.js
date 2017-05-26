//生成二维码
		createSsjlQRCode();
		//顶部连接
		$("#topLog").on('click',function(){
			alert(0);
		});
		
		//触发鼠标经过原点移动变化图片事件
		function showCarousel(obj){
		var index = parseInt($(obj).attr('data-slide-to'));
		$('.carousel').carousel(index);
		}
		//生成二维码
		function createSsjlQRCode(){
			$('#firstQRcode').empty();
			jQuery('#firstQRcode').qrcode({
				render: 'canvas',
				text: 'http://112.74.108.51:9090/YinYangShi/home.html',
				width : "80",               //二维码的宽度  
		        height : "80",              //二维码的高度  
		        imgWidth : 220/4,			 //图片宽
		        imgHeight : 220/4,			 //图片高
				src: 'img/logo.jpg'//图片中央的二维码  */	
			});
			$('#firstQRcode').attr("qrcode", "张弛的店");
			//$("canvas").attr("id", "canvasImg");
			$('#firstQRcode').find('canvas').attr('id', 'canvasImg');
			//将二维码转换成图片用于打印
			var canvas = document.getElementById('canvasImg');
			var image = new Image();
			var strDataURL = canvas.toDataURL("image/png");
			document.getElementById("myImg").src = strDataURL;
}
		//鼠标经过改变左边菜单底色
		function changeClassify(obj){
			var id = $(obj).attr('id');
			$("#"+id).css('background-color','#999395');
		}
		
		//鼠标移开还原样式
		function removeClassify(obj){
			var id = $(obj).attr('id');
			$("#"+id).css('background-color','#6E6568');
		}
		
		//切换显示促销和公告 也可以写两个div切换显示就不用请求后台了
		function showNotice(obj){//0代表促销显示促销内容，1代表公告显示公告内容
			var type = $(obj).attr('data-type');
			var html = "";
			$("#notice").empty();
			if(type=="0"){
				html +="<p><a href='#' style='color: #666F8C;'>宝生元春季家装厨卫大放送</a></p><p><a href='#' style='color: #666F8C;'>家电满5000送1999礼券</a></p><p><a href='#' style='color: #666F8C;'>疯狂星期五，爆品2件5折</a></p><p><a href='#' style='color: #666F8C;'>200元E卡免费抽</a></p>";
			}else if(type=="1"){
				html +="<p><a href='#' style='color: #666F8C;'>京东热水器品类安装收费封顶</a></p><p><a href='#' style='color: #666F8C;'>英国超市ASDA入驻京东</a></P><p><a href='#' style='color: #666F8C;'>京东与欧莱雅中国合作升级</a></p><p><a href='#' style='color: #666F8C;'>京东生鲜即刻赔 告别退货难</a></p>";
			}
			$("#notice").html(html);
		}
		
		//显示地址浮动层
		/*function showModel(){
			$("#addressModel").css('background-color','#FFFFFF');
			 panel = $.jsPanel({
    			headerTitle: '请选择所在城市',
    			headerRemove:true,
    			contentSize:{width:350,hegiht:40},
    			position:{of:"#address",my: "left-bottom",at: "right-bottom",offsetY:203,offsetX:-70},
    			content:     '<a >北京</a>',
    			callback:function(panel){
    				
    			}
			 });
		}*/
		
		//影藏地址浮动层
		/*function hideModel(){
			$("#addressModel").css('background-color','#E3E4E5');
			panel.close();
		}*/