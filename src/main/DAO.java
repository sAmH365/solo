package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521/xe";
	String user = "green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	String query;
	CreateXml xml  = new CreateXml();
	Parsing parsing = new Parsing();
	imageDown down = new imageDown();
	
	
//회원번호 초기화
	public int userNo(){
		int cnt = 0;
		try {
			connDB();
			query = "SELECT count(USER_NO) con FROM mem";
			//System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
				while (rs.next()) {
					cnt =Integer.parseInt(rs.getString("CON"));
					System.out.println(cnt);
				}
			}

		 catch(Exception e) {
			e.printStackTrace();
		}
	return cnt;
	}//userNo() end
	
//회원정보 db저장
	public int register(String name,String reg_no,String id,String pwd,String address,int cont) {
		connDB();
		int cnt = cont;		
		try {	
			    query = "INSERT INTO MEM values('"+name+"','"+reg_no+"','"+id+"','"+pwd+"','"+address+"',"+cont+")";
				rs = stmt.executeQuery(query);
				JOptionPane.showMessageDialog(null,"회원가입 되었습니다.");
				cnt++;
		   				    
			System.out.println(checkId(id));	
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"이미 등록된 회원입니다.");
			
		}
		return cnt;
	} //register() end
	
	
//아이디 중복확인
	public boolean checkId(String id) {
		connDB();
		boolean check = false;
		query = "SELECT id FROM MEM";
		if(Start.cont==0 ) {
			check = true;
			//System.out.println(check);
			return check;
		}
		try {
			rs = stmt.executeQuery(query);
			while (rs.next()) {
			if(id.equals(rs.getString("ID"))) {
				System.out.println(rs.getString("ID"));
				check = false;
			}else {
				check = true;
			}
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return check;
	}//checkId end
	
//로그인
	public boolean login(String id, String pwd) {
		connDB();
		boolean check = false;
		query = "SELECT id,pwd FROM MEM m";
			
	try {
			rs = stmt.executeQuery(query);
		while (rs.next()) {
				if(id.equals(rs.getString("ID"))) {
					System.out.println("ID 실행");
					if(rs.getString("PWD").equals(pwd)) {
						System.out.println("pwd 실행");
						check = true;
						break;
					}else {
						check=false;
					}
				}else {
					check = false;
				}
				
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return check;
			
		}//login() end
	
//search list
	public Vector searchN(String area) {
		connDB();
		int i=0,j=0;
		Vector<String> vector = new Vector<String>();
		String arr[] = {"서울","인천","대전","대구","광주","부산","울산","세종특별자치시","경기도","강원도","충청북도","충청남도","경상북도","경상남도","전라북도","전라남도","제주도"};
		for(i=0;i<arr.length;i++) {
		if(i>=8) {
			if(arr[i].equals(area))
			j = i+23;
		}else {	
		    if(arr[i].equals(area))
		    j=i+1;
		  }
	}
		query = "SELECT TITLE FROM LIST l WHERE CAT_NO = 'A0101' AND AREA_NO = '"+j+"'";
		
		try {
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				vector.addElement((rs.getString("TITLE"))); 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vector;
		
	}
	
    //expSearchlist	
	public Vector searchE(String area) {
		connDB();
		int i=0,j=0;
		Vector<String> vector = new Vector<String>();
		String arr[] = {"서울","인천","대전","대구","광주","부산","울산","세종특별자치시","경기도","강원도","충청북도","충청남도","경상북도","경상남도","전라북도","전라남도","제주도"};
		for(i=0;i<arr.length;i++) {
		if(i>=8) {
			if(arr[i].equals(area))
			j = i+23;
		}else {	
		    if(arr[i].equals(area))
		    j=i+1;
		  }
	}
		query = "SELECT TITLE FROM LIST l WHERE CAT_NO = 'A0203' AND AREA_NO = '"+j+"'";
		
		try {
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				vector.addElement((rs.getString("TITLE"))); 
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vector;
		
	}
	
	//hisSearchlist
	public Vector searchH(String area) {
		connDB();
		int i=0,j=0;
		Vector<String> vector = new Vector<String>();
		String arr[] = {"서울","인천","대전","대구","광주","부산","울산","세종특별자치시","경기도","강원도","충청북도","충청남도","경상북도","경상남도","전라북도","전라남도","제주도"};
		for(i=0;i<arr.length;i++) {
		if(i>=8) {
			if(arr[i].equals(area))
			j = i+23;
		}else {	
		    if(arr[i].equals(area))
		    j=i+1;
		  }
	}
		query = "SELECT TITLE FROM LIST l WHERE CAT_NO = 'A0201' AND AREA_NO = '"+j+"'";
		
		try {
			rs=stmt.executeQuery(query);
			while(rs.next()) {
				vector.addElement((rs.getString("TITLE")));
							}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return vector;
		
	}
	
//관광지 정보 조회(cont_id)
	public int contIdInfo(String sel) {
		connDB();
		int i=0;
		query = "SELECT cont_id FROM LIST l WHERE TITLE  = "+"'"+sel+"'";
		System.out.println(query);
		try {
			rs =stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("CONT_ID"));
				i = Integer.parseInt(rs.getString("CONT_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return i;
		
	}
//관광지 정보 조회(general Information)
	public void infomation(int contId) {
		connDB();
		xml.info(contId);
		
	}
	
	

	
	
	//DB연결
	public void connDB() {
		try {
			
			Class.forName(driver);
			//System.out.println("jdbc driver loading success.");
			setCon(DriverManager.getConnection(url, user, password));
			//System.out.println("oracle connection success.");
			
			//stmt = con.createStatement();
			setStmt(getCon().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE));
			//System.out.println("statement create success.");
						
				} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
