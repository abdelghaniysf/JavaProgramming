package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        Connection con = null;
        String url = "jdbc:mysql://localhost/mocro";
        try {
            con = DriverManager.getConnection(url, "root", "");
            String consulta = "SELECT * FROM destino";
            PreparedStatement sentencia = con.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                int idDestino = resultado.getInt("IdDestino");
                String nAerop = resultado.getString("nAerop");
                String codCiudad = resultado.getString("CodCiudad");
                System.out.println("IdDestino: " + idDestino + ", nAerop: " + nAerop + ", CodCiudad: " + codCiudad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
