/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author System Web
 */
@WebServlet(name = "/downloaded", urlPatterns = {"/downloaded"})
public class downloaded extends HttpServlet {

    String UPLOAD_DIRECTORY;

//    String fname;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
        System.out.println("download servlet");
        /* TODO output your page here. You may use following sample code. */
        try {
            HttpSession session = request.getSession();
            String sha_key1;
            String querydata = request.getQueryString();
            session.setAttribute("query", querydata);
            String algo = querydata.substring(querydata.lastIndexOf("&") + 1);
            if (algo.equals("DES")) {
                System.out.println("DES");
                response.sendRedirect("downloadDES");
            } else if (algo.equals("AES")) {
                if (querydata.contains("%20")) {
                    querydata = querydata.replace("%20", "");
                }
                String f1 = querydata.substring(0, querydata.indexOf("&"));
                String uid = querydata.substring(querydata.indexOf("&") + 1, querydata.lastIndexOf("&"));
                System.out.println("file " + f1 + " id " + uid);
                f1 = f1.replace("%20", " ");
                UPLOAD_DIRECTORY = getServletContext().getRealPath("");
                UPLOAD_DIRECTORY = UPLOAD_DIRECTORY.substring(0, UPLOAD_DIRECTORY.lastIndexOf(File.separator));
                UPLOAD_DIRECTORY = UPLOAD_DIRECTORY.substring(0, UPLOAD_DIRECTORY.lastIndexOf(File.separator));
                UPLOAD_DIRECTORY = UPLOAD_DIRECTORY.substring(0, UPLOAD_DIRECTORY.lastIndexOf(File.separator));
                String key = "";
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online", "root", "1212");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("select Encr_key from upload_data where filename='" + f1 + "' and userid='" + uid + "'");
                while (rs.next()) {
                    key = rs.getString(1);
                }
                File f = new File(UPLOAD_DIRECTORY + File.separator + "Encrypted" + File.separator + f1);
                FileInputStream fin1 = new FileInputStream(UPLOAD_DIRECTORY + File.separator + "Encrypted" + File.separator + f1);
                int len = (int) f.length();
                byte[] bar = new byte[len];
                fin1.read(bar);
                byte[] bar1 = new byte[len];
                bar1 = bar;
                byte[] original = AES.decrypt(bar1, key);
                sha_key1 = SHA1.sha256(original);
                Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/online", "root", "1212");
                Statement st2 = con.createStatement();
                st2.execute("update upload_data set SHA2_key='" + sha_key1 + "' where userid='" + uid + "' and  filename='" + f1 + "' ");
                session.setAttribute("filename", f1);
                File fa = new File(UPLOAD_DIRECTORY + File.separator + "Decrypt" + File.separator + f1);
                FileOutputStream fis = new FileOutputStream(fa);
                fis.write(original);
                fis.close();
                session.setAttribute("fname", f1);
                session.setAttribute("email", uid);
                response.sendRedirect("download1");
                // gets MIME type of the file
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
