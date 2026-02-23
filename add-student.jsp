<h2>Add Student</h2>
<form action="<%=request.getContextPath()%>/addStudent" method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="text" name="email"><br><br>
    Course: <input type="text" name="course"><br><br>
    GPA: <input type="text" name="gpa"><br><br>
    <input type="submit" value="Add">
</form>
