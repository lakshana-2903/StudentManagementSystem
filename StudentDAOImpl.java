package com.school.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.school.model.Student;
import com.school.util.DBConnection;
public class StudentDAOImpl implements StudentDAO {
    @Override
    public void addStudent(Student student) {
        System.out.println("DAO addStudent method called");
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Connection = " + con);
            String sql = "INSERT INTO student (name, email, course, gpa) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setFloat(4, student.getGpa());
            int rows = ps.executeUpdate();
            System.out.println("Inserted rows = " + rows);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM student";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setGpa(rs.getFloat("gpa"));
                list.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void updateStudent(Student student) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE student SET name=?, email=?, course=?, gpa=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getCourse());
            ps.setFloat(4, student.getGpa());
            ps.setInt(5, student.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void deleteStudent(int id) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
