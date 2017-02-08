<%-- 
    Document   : learinfo
    Created on : Aug 18, 2009, 12:06:59 PM
    Author     : mnm
--%>
<%@ taglib uri="http://www.zkoss.org/jsp/zul" prefix="z" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page<title>
    </head>
    <body>
       <div align="right">
        <z:page zscriptLanguage="java"><z:include src="info.zul"/>
        <z:window title="صفحه ورود اطلاعات مدرسه" border="normal">
	<z:bandbox id="bd">
		<z:bandpopup>
			<z:vbox>
				<z:hbox>
					Search
					<z:textbox />
				</z:hbox>
				<z:listbox width="200px"
					onSelect="bd.value=self.selectedItem.label; bd.closeDropdown();">
					<z:listhead>
						<z:listheader label="Name" />
						<z:listheader label="Description" />
					</z:listhead>
					<z:listitem>
						<z:listcell label="John" />
						<z:listcell label="CEO" />
					</z:listitem>
					<z:listitem>
						<z:listcell label="Joe" />
						<z:listcell label="Engineer" />
					</z:listitem>
					<z:listitem>
						<z:listcell label="Mary" />
						<z:listcell label="Supervisor" />
					</z:listitem>
				</z:listbox>
			</z:vbox>
		</z:bandpopup>
	</z:bandbox>

    <z:button id="mnms"  label="Down" action="onclick:  zk.hide(#{win});anima.moveDown(#{win})" />
    <z:button id="mnmss"  label="Down" onClick="win.setVisible(true)" />


       </z:window>
        
        <z:window id="win" border="normal" width="200px" position="center"
			mode="overlapped"
			
			visible="false">
		<z:caption label="Hi there!" />
		<z:label onClick="win.setVisible(false)" value="Hello, Effects!" />
	</z:window>

        </z:page>
        </div>
    </body>
</html>
