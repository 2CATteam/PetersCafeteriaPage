<!--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->
<html><head>
        <title>Using Buttons</title>
    </head>

    <body>
        <% 
            if(request.getParameter("buttonName") != null) {
            //if(request.getParameterNames() != null) {
        %>
            You clicked 
            <%= request.getParameter("buttonName") %>
        <%
            }
        %>

        <form name="form1" method="POST">
            <input type="HIDDEN" name="buttonName">
            <input type="BUTTON" value="Button 1" onclick="button1()">
            <input type="BUTTON" value="Button 2" onclick="button2()">
        </form>

        <script>
            
            function button1()
            {
                document.form1.buttonName.value = "button 1"
                form1.submit()
            }    
            function button2()
            {
                document.form1.buttonName.value = "button 2"
                form1.submit()
            }    
             
        </script>
    
</body></html>