<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="rtl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>نرم افزار زمان بند</title>
	<link type="text/css" href="js/themes/base/ui.all.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.3.2.js"></script>
	<script type="text/javascript" src="js/ui/ui.core.js"></script>
	<script type="text/javascript" src="js/ui/ui.draggable.js"></script>
	<script type="text/javascript" src="js/ui/ui.resizable.js"></script>
	<script type="text/javascript" src="js/ui/ui.dialog.js"></script>
	<script type="text/javascript" src="js/ui/effects.core.js"></script>
	<script type="text/javascript" src="js/ui/effects.highlight.js"></script>
	<script type="text/javascript" src="js/external/bgiframe/jquery.bgiframe.js"></script>
	<link type="text/css" href="js/demos.css" rel="stylesheet" />



<link rel="stylesheet" type="text/css" media="all" href="js/skins/aqua/theme.css" title="Aqua" />
<script type="text/javascript" src="js/jalali.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/calendar-setup.js"></script>
<script type="text/javascript" src="js/lang/calendar-fa.js"></script>
</head>
<body>
    <style>
			.btndiv .z-button-cr, .btndiv .z-button-cl,
			.btndiv .z-button-bl, .btndiv .z-button-bm,
			.btndiv .z-button-br, .btndiv .z-button-tl,
			.btndiv .z-button-tm, .btndiv .z-button-tr {
					background-image:none;
				}
				.btndiv .z-button-cm {
					background : transparent url('') no-repeat 0 0 ;
				}
			.myBlack .z-button-cm {
				background-image : url(img/r-button.png);
			}

			.z-button-focus .z-button-cm {
				background-position: 0 -62px
			}
			.z-button-over .z-button-cm {
				background-position: 0 -30px
			}
			.z-button-clk .z-button-cm {
				background-position: 0 -93px
			}
		</style>
<div align="right">
<z:page zscriptLanguage="java" >
<z:include src="ttp_genetic.zul"/>
</z:page>
</div>
</body>
</html>