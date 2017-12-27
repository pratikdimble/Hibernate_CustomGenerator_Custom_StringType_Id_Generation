package com.app.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


/*CREATE SEQUENCE coupen_seq
  MINVALUE 1
  START WITH 1
  INCREMENT BY 1
 / 
 
  */

public class CustomRandomGenerator implements IdentifierGenerator 
{

	@Override
	public Serializable generate(SharedSessionContractImplementor ses, Object obj) throws HibernateException 
	{
		try
		{
			Connection  con=ses.connection();
			PreparedStatement ps=con.prepareStatement("select coupen_seq.nextVal from dual");
			ResultSet rs=ps.executeQuery();
			
				int id=0;
					if(rs.next())
					{
						id=rs.getInt(1);
					}
						if (id<10)
						{
							return "Bajaj00"+id;
						}
						else if(id<12)
						{
							return "Relience00"+id;
						}
							else
							{
								return "DMart00"+id;
							}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed To Generate ID Value";
		}
	

}
