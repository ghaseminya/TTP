<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html dir="rtl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A simple Capcha Demo</title>
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

			<z:borderlayout height="950px" style="background:#BFE0F0;">
<z:north size="80px" border="0" style="background:#BFE0F0;">

        <z:div>

            <z:div align="center">
			<z:label id="tes1" style="font-family: 'B Titr';font-weight:bold;color:green;font-size:12pt" value="نرمافزار زمان بند "/>
            </z:div>

            <z:div align="left">
 				<z:button label="جستجوی سایت"/><z:textbox style="text-align:right" sclass="demo-search-inp"/>
			</z:div>

		</z:div>
	</z:north>


<z:center   >

                  </z:center>
<z:south style="background:#054E7E">
<z:toolbar mold="panel" align="center">
			<z:toolbarbutton label="Sign in"/>
			<z:toolbarbutton label="خانه" style="font-size:7pt;">
                <z:attribute name="onClick">
                    cen1.setSrc("center.zul");
                </z:attribute>
                </z:toolbarbutton>
			<z:toolbarbutton label="داده" style="font-size:7pt;">
                <z:attribute name="onClick">
                    cen1.setSrc("learninfo.zul");
                </z:attribute>
                </z:toolbarbutton>
			<z:toolbarbutton label="Terms" style="font-size:7pt;"/>
			<z:toolbarbutton label="Report Abuse" style="font-size:7pt;"/>
			<z:toolbarbutton label="Print" style="font-size:7pt;"/>
			<z:separator orient="vertical" bar="true" style="font-size:7pt;"/>

			<z:toolbarbutton label="ADOJI  شرکت " style="font-size:7pt;">
                <z:attribute name="onClick" >{
             final Window win = (Window) wins;
                 win.doModal();
             }
             </z:attribute>
            </z:toolbarbutton>
            <z:label value="تمام حقوق مالی ومعنوی متعلق به" style="font-size:7pt;"/>

		</z:toolbar>
</z:south>
			</z:borderlayout>
            <z:window id="wins"  border="normal" visible="false">
    <z:caption><z:label value="ADOJI  شرکت تولید و نگهداری نرم افزار های سازمانی " style="font-family:'B Titr';font-size:10pt;color:green"/></z:caption>
    <div align="center">
    <z:toolbarbutton label="محمد قاسمی‌نیا"  href="mailto:mohammad.ghasemy@gmail.com" style="font-family:'B Titr';font-size:10pt"/>
    <z:label value="  دانشجوی کامپیوتر  " style="font-family:'B Titr';font-size:10pt"/>
    <br>
        <br>
            <z:hbox>

        <z:toolbarbutton label="WWW.ADOJI.Ir"  href="http://WWW.ADOJI.Ir" />
        <z:label value="آدرس سایت" style="font-family:'B Titr';font-size:10pt"/>
        </z:hbox><br>
        <z:toolbarbutton label="صفحه شخصی طراح"  href="http://WWW.mGHasemI.Ir" style="font-family:'B Titr';font-size:10pt"/>
        <br><div align="left"><z:image src="/img/close.png" onClick="wins.setVisible(false)"/></div>
</div>

</z:window>
</z:page>
</div>
</body>
</html>