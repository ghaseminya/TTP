<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>A simple Capcha Demo</title>
</head>
<body>
<div align="right">
    
<z:page zscriptLanguage="java"><z:include src="info.zul"/>
			<z:borderlayout height="650px" style="background:#c5e6ef;">
<z:north size="80px" border="0" style="background:#96D0FF;">
		
        <z:div>
			
            <z:div align="center">
			<z:label style="font-family: 'B Titr';font-weight:bold;color:green;font-size:12pt" value="نرمافزار زمان بند "/>
            </z:div>
            
            <z:div align="left">
 				<z:button label="جستجوی سایت"/><z:textbox style="text-align:right" sclass="demo-search-inp"/>
			</z:div>

		</z:div>
	</z:north>

<z:west>
		<z:panel width="100%" border="normal" title="Navigation">
				<z:panelchildren style="padding:5px;">
					<z:vbox>
						<z:toolbarbutton label="خانهه"/>
						<z:toolbarbutton label="Sitemap"/>
						<z:toolbarbutton label="دمو"/>
						<z:toolbarbutton label="ZK Team"/>
						<z:toolbarbutton label="Releases"/>
						<z:toolbarbutton label="Calender"/>
					</z:vbox>
				</z:panelchildren>
			</z:panel>
	</z:west>
<z:east width="150px" title="لینک سریع" flex="true" margins="0,5,5,0" collapsible="true">
		<z:panel width="100%" border="normal" title="Navigation">
				<z:panelchildren style="padding:5px;">
					<z:vbox>
						<z:toolbarbutton label="Home"/>
						<z:toolbarbutton label="Sitemap"/>
						<z:toolbarbutton label="Statement of Direction"/>
						<z:toolbarbutton label="ZK Team"/>
						<z:toolbarbutton label="Releases"/>
						<z:toolbarbutton label="Calender"/>
					</z:vbox>
				</z:panelchildren>
			</z:panel>
	</z:east>
				<z:center border="0">
	<z:tablelayout columns="2">
			<z:tablechildren colspan="2">
				<z:panel>
					<z:panelchildren>
                        
						<z:label value="HOME" style="font-size:20px;"/>
					</z:panelchildren>
				</z:panel>
			</z:tablechildren>
			<z:tablechildren  width="50%">
				<z:panel title="Reference" border="normal">
					<z:panelchildren>
						<z:grid fixedLayout="true" style="border:0;">
						<z:rows>
							<z:row><z:div><z:toolbarbutton label="Functional Designs"/>(<z:toolbarbutton label="Releases"/>, <z:toolbarbutton label="Designs"/>, Product Overview)</z:div></z:row>
							<z:row><z:div><z:toolbarbutton label="Technical Docs"/></z:div></z:row>
						</z:rows>
						</z:grid>
					</z:panelchildren>
				</z:panel>
			</z:tablechildren>
			<z:tablechildren  width="50%">
				<z:panel title="Customer Overview" border="normal"
						style="margin-bottom:10px">
					<z:panelchildren>
						<z:grid fixedLayout="true" style="border:0px" height="100%">
							<z:columns>
								<z:column label="category" />
								<z:column label="value" />
							</z:columns>
							<z:rows>
								<z:row>
									<z:label id="c0" value="Europe" />
									<z:decimalbox id="v0" value="41.2"
										constraint="no empty"  />
								</z:row>
								<z:row>
									<z:label id="c1" value="Africa" />
									<z:decimalbox id="v1" value="5.2"
										constraint="no empty" />
								</z:row>
								<z:row>
									<z:label id="c2" value="America" />
									<z:decimalbox id="v2" value="36.4"
										constraint="no empty" />
								</z:row>
								<z:row>
								<z:label id="c3" value="Australia" />
								<z:decimalbox id="v3" value="18.2"
									constraint="no empty" />
							</z:row>
							<z:row>
							<z:label id="c4" value="Asia" />
							<z:decimalbox id="v4" value="28.2"
								constraint="no empty" />
						</z:row>
							</z:rows>
						</z:grid>
					</z:panelchildren>
				</z:panel>
			</z:tablechildren>

		</z:tablelayout>
				</z:center>
<z:south>
<z:toolbar mold="panel" align="center">
			<z:toolbarbutton label="Sign in"/>
			<z:toolbarbutton label="Home"/>
			<z:toolbarbutton label="Sitemap"/>
			<z:toolbarbutton label="Terms"/>
			<z:toolbarbutton label="Report Abuse"/>
			<z:toolbarbutton label="Print"/>
			<z:separator orient="vertical" bar="true"/>
			Powered by
			<z:toolbarbutton label="ZK Borderlayout"/>
		</z:toolbar>
</z:south>
			</z:borderlayout>
</z:page>
</div>
</body>
</html>