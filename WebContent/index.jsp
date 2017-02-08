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

<z:borderlayout height="950px" style="background:#BFE0F0;">
<z:north size="85px" border="0" style="background:#BFE0F0;">

        <z:div align="center">
            <z:hbox align="top">
                <z:div class="btndiv" class="demo" align="left">
            <z:label value=" مدیر زمان " sclass="ui-button ui-state-default ui-corner-all" width="50px" style="font-family:'B Chini'; font-weight:bold;font-size:30pt;color:blue"/>
            <z:label id="now" sclass="ui-button ui-state-default ui-corner-all" width="50px"/>
            	
                </z:div>
            <z:div align="center">
			<z:image id="tes1" style="" src="img/indename.png" width="150px" height="60px"/>
            </z:div></z:hbox>

           <div class="btndiv" class="demo" align="left">
 				<z:button label="جستجوی" sclass="ui-button ui-state-default ui-corner-all"  width="60px"/><z:textbox style="text-align:right" sclass="demo-search-inp"/>
			</div>

		</z:div>
	</z:north>


<z:east width="150px" title="لینک سریع" flex="true" margins="0,5,5,0" collapsible="true">
		<z:panel width="100%" border="normal" title="منو های اصلی" style="text-align:right">
				<z:panelchildren style="padding:5px;text-align:right; padding-left:5px">
					<z:vbox align="center">
						

<z:panel id="firs" title="مرحله ورود داده"  border="normal" collapsible="true" onOpen="stat.setOpen(false);resu.setOpen(false)">
    <z:panelchildren style="background:#FFE2A7">
        		
		<div class="btndiv" class="demo" align="center">
			<br/><z:button id="bmn1" label="اطلاعات اولیه " height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="106px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("learninfo.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
            </z:button>
                <br/><z:separator bar="true"/>
<z:button id="bmn2" label="اسلتید محترم" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="106px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                <z:attribute name="onClick">
                    cen1.setSrc("asatid.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
</z:button>
            <br/><z:separator bar="true"/>
            <z:button id="bmmn3" label="برنامه کلاس ها" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="106px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            
            >
                <z:attribute name="onClick">
                    cen1.setSrc("class.zul");
                      wi.setTitle("لیست کلاس ها موسسه");
                </z:attribute>
            </z:button>
                        <br/>
		</div>
      </z:panelchildren>
</z:panel>


<z:panel id="stat" title="آمار ها"  border="normal" collapsible="true" open="false" onOpen="firs.setOpen(false);resu.setOpen(false)">
    <z:panelchildren style="background:#FFE2A7">

		<div class="btndiv" class="demo" align="center">
			<br/><z:button id="mn1" label="لیست اساتید" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="106px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("/view/masstat.zul");
                      wi.setTitle("لیست کل اساتید موسسه");
                </z:attribute>
            </z:button><z:separator bar="true"/><z:button id="mn12" label="لیست دروس" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="106px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("/view/darsstat.zul");
                      wi.setTitle("لیست دروس");
                </z:attribute>
            </z:button>
               <z:separator bar="true"/> 
<z:button id="mn2" label="لیست کلاس ها" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="106px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                <z:attribute name="onClick">
                    cen1.setSrc("/view/classstat.zul");
                      wi.setTitle("لیست کلیه کلاس ها");
                </z:attribute>
</z:button>
            <br/>
            
                        
		</div>
      </z:panelchildren>
</z:panel>
<z:panel id="ttp" title="زمانبند هوشمند"  border="normal" collapsible="true" open="false" onOpen="firs.setOpen(false);stat.setOpen(false)">
    <z:panelchildren style="background:#FFE2A7">

		<div class="btndiv" class="demo" align="center">

            <br/>
            <z:button id="ttpb1" label="زمانبندی" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})">
                <z:attribute name="onClick">
                    cen1.setSrc("ttp_genetic.zul");
                      wi.setTitle("زمانبندی");
                </z:attribute>
            </z:button>
            <z:separator bar="true"/>
            <z:button  label="نتایج براساس دروس" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("learninfo.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
            </z:button>
            <br/>
		</div>
      </z:panelchildren>
</z:panel>
<z:panel id="resu" title="نتایج"  border="normal" collapsible="true" open="false" onOpen="firs.setOpen(false);stat.setOpen(false)">
    <z:panelchildren style="background:#FFE2A7">

		<div class="btndiv" class="demo" align="center">
			<br/>
            <z:button  label="نتایج براساس کلاس" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("learninfo.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
            </z:button><z:separator bar="true"/>
            <z:button  label="نتایج براساس دروس" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("learninfo.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
            </z:button><z:separator bar="true"/>
            <z:button id="bn1" label="نتایج براساس اساتید" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                  <z:attribute name="onClick">
                    cen1.setSrc("learninfo.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
            </z:button><z:separator bar="true"/>
                
<z:button id="bn2" label="نتایج براساس کلاس۲" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"
            >
                <z:attribute name="onClick">
                    cen1.setSrc("asatid.zul");
                      wi.setTitle("اطلاعات اولیه موسسه");
                </z:attribute>
</z:button><z:separator bar="true"/>
            
            <z:button id="bmn3" label="پرینت" height="25px" sclass="ui-button ui-state-default ui-corner-all"  width="116px"
            action="onfocus: window.action.show(#{help1}); onblur: window.action.hide(#{help1})"

            >
                <z:attribute name="onClick">
                    cen1.setSrc("class.zul");
                      wi.setTitle("لیست کلاس ها موسسه");
                </z:attribute>
            </z:button>
                        <br/>
		</div>
      </z:panelchildren>
</z:panel>
<div class="demo">
<button id="create-user4" class="ui-button ui-state-default ui-corner-all">آمار کل موسسه</button>
</div>
<div class="demo">
<button id="create-user5" class="ui-button ui-state-default ui-corner-all">آمار کل موسسه</button>
</div>
<div class="demo">
<button id="create-user6" class="ui-button ui-state-default ui-corner-all">آمار کل موسسه</button>
</div>
					</z:vbox>
				</z:panelchildren>
			</z:panel>
	</z:east>
				<z:center   >
                    <z:panel id="wi" border="normal" title="اطلاعات اولیه موسسه" ><z:panelchildren>
                    <z:include id="cen1" src="learninfo.zul"  />
                    </z:panelchildren></z:panel>
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