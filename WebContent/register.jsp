<%-- 
    Document   : register
    Created on : Aug 15, 2009, 4:25:31 PM
    Author     : mnm
--%>

﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>
<html dir="rtl">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <z:page >
<z:window
title="mnm is ok"
droppable='true'
mold='default'
minimized='false'
moldSclass='z-window-embedded'
width='100%'
sizable='false'
mode='embedded'
minwidth='500'
ZIndex='-1'
maximized='false'
height='100%'
style='background-color:rgb(255, 255, 255); z-index:1000'
closable='false'
zclass='z-window-embedded'
shadow='true'
minimizable='false'
border='none'
draggable='false'
zindex='-1'
maximizable='false'
minheight='100'
>

	<z:grid fixedLayout="true">
		<z:columns sizable="true">
			<z:column label="Brand" />
			<z:column label="Processor Type" width="150px"/>
			<z:column label="Memory (RAM)" width="120px"/>
			<z:column label="Price"  width="100px"/>
			<z:column label="Hard Drive Capacity" width="150px"/>
		</z:columns>
		<z:rows>
			<z:group label="Dell"/>
			<z:row>
				<z:label style="padding-left:15px" value="Dell E4500 2.2GHz"/>
				<z:label value="Intel Core 2 Duo"/>
				<z:label value="2GB RAM"/>
				<z:label value="$261.00" style="color:green"/>
				<z:label value="500GB"/>
			</z:row>
			
			
		</z:rows>
	</z:grid>
    <z:panel id="panel" framable="true" width="500px" height="400px"
	title="Panel"
	maximizable="true" minimizable="true" border="normal"
	collapsible="true" closable="true">
					<z:panelchildren>
						<z:borderlayout>
						<z:center flex="true">
							<z:div id="viewer" style="overflow:auto;"/>
						</z:center>
						<z:south splittable="true" size="25%"  flex="true">
							<z:textbox id="text" multiline="true" width="98%" style="margin:0px" value="Hi, I am Jumper. (Please press the OK Button)"/>
						</z:south>
						</z:borderlayout>
					</z:panelchildren>
				</z:panel>
                </z:window>
                <z:window
droppable='true'
mold='default'
minimized='false'
moldSclass='z-window-embedded'
width='100%'
sizable='false'
mode='embedded'
minwidth='500'
ZIndex='-1'
maximized='false'
height='100%'
style='background-color:rgb(255, 255, 255); z-index:1000'
closable='false'
zclass='z-window-embedded'
shadow='true'
minimizable='false'
border='none'
draggable='false'
zindex='-1'
maximizable='false'
minheight='100'
>

<z:div
id='1246283909781'
ZIndex='-1'
mold='default'
height='20px'
style='position:absolute;z-index:1000; padding:0px'
width='80px'
left='294px'
draggable='false'
top='111px'
zindex='-1'
>
<z:label
droppable='false'
mold='default'
moldSclass='z-label'
width='100%'
ZIndex='-1'
height='100%'
style='position:absolute'
zclass='z-label'
multiline='false'
pre='false'
value='label'
draggable='false'
zindex='-1'
hyphen='false'
>
</z:label>
</z:div>
<z:div
id='1246283546406'
ZIndex='-1'
mold='default'
height='23px'
style='position:absolute;z-index:1000; padding:0px'
width='71px'
left='401px'
draggable='false'
top='108px'
zindex='-1'
><z:div align="right">
<z:button
droppable='false'
mold='default'
moldSclass='z-button'
width='100%'
tabindex='-1'
label='button'
ZIndex='-1'
height='100%'
orient='horizontal'
style='position:absolute'
zclass='z-button'
dir='normal'
disabled='false'
draggable='false'
zindex='-1'
>
<z:attribute name="onClick">
    alert("mnm is ok");
</z:attribute>
</z:button>
</z:div></z:div>
</z:window>

	    </z:page>
        <h1>Hello World!</h1>
    </body>
</html>
