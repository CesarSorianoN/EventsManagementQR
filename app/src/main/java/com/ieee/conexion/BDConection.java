package com.ieee.conexion;


import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConection {

    private Connection connection = null;

	/** Constructor */

	public BDConection() {
        String bd = "eventsmanagementqr";
        String login = "root";
        String password = "12345678";
        String host = "192.168.0.7";
        String url = "jdbc:mysql://192.168.0.7/" + bd;

        try {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy);
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
			// obtenemos la conexi�n
			connection = DriverManager.getConnection(url, login, password);

			if (connection != null) {
			//	System.out.println("Conexi�n a base de datos " + bd + " OK\n");//
				Log.d("W","Conexi�n a base de datos " + bd + " OK");
			}

		} catch (SQLException e) {
			//System.out.println(e);
			Log.d("E",e.getMessage());
		} catch (ClassNotFoundException e) {
			//System.out.println(e);
			Log.d("E",e.getMessage());
		} catch (Exception e) {
			Log.d("E",e.getMessage());
			//System.out.println(e);
		}
	}


	/** Permite retornar la conexi�n */
	public Connection getConnection() {
		//System.out.println("Coneccion:"+connection);
		Log.d("W","Coneccion:"+connection);
			return connection;
	}

	public void desconectar() {
		connection = null;
	}
}
