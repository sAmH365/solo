package main;

import java.awt.Dimension; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Start extends JFrame {
	ImagePanel panel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//login.jpg").getImage());
	ImagePanel regPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//login2.jpg").getImage());
	ImagePanel mainPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main.jpg").getImage());
	ImagePanel naturePanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_nature.jpg").getImage());
	ImagePanel expPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_exp.jpg").getImage());
	ImagePanel hisPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_his.jpg").getImage());
	ImagePanel bookmarkPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_bookmark.jpg").getImage());
	ImagePanel achievePanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_achieve.jpg").getImage());
	ImagePanel ninfoPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_nature.jpg").getImage());
	ImagePanel einfoPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_exp.jpg").getImage());
	ImagePanel hinfoPanel = new ImagePanel(new ImageIcon("D:/505/WS2/Solo/Pimage//main_his.jpg").getImage());
	
	private String currentUser;
	private String nimg = "./test.jpg";
	private String sel;
	private JTextField idField;
	private JPasswordField pwdField;
	private JTextField regName;
	private JTextField regId;
	private JTextField regPwd;
	private JTextField regNo;
	private JTextField regAdd;
	private JPanel currentPage;
	private JPanel achievePage;
	private JPanel naturePage;
	private JPanel expPage;
	private JPanel bookmarkPage;
	private JPanel hisPage;
	private JPanel natureP_search= new JPanel();
	private JPanel expP_search =new JPanel();
	private JPanel hisP_search = new JPanel();
	private ImagePanel IP;
	JLabel ninfoIMG = new JLabel("no img");
	JTextPane ninfoAddressText = new JTextPane();
	JTextPane ninfoOverviewText = new JTextPane();
	JPanel expinfoPage = new JPanel();
	String[] headings = new String[] {"Title", "Area"};
		
	private JRadioButton area_1 = new JRadioButton("서울");
	private JRadioButton area_2 = new JRadioButton("인천");
	private JRadioButton area_3 = new JRadioButton("대전");
	private JRadioButton area_4 = new JRadioButton("대구");
	private JRadioButton area_5 = new JRadioButton("광주");
	private JRadioButton area_6 = new JRadioButton("부산");
	private JRadioButton area_7 = new JRadioButton("울산");
	private JRadioButton area_8 = new JRadioButton("세종특별자치시");
	private JRadioButton area_31 = new JRadioButton("경기도");
	private JRadioButton area_32 = new JRadioButton("강원도");
	private JRadioButton area_33 = new JRadioButton("충청북도");
	private JRadioButton area_34 = new JRadioButton("충청남도");
	private JRadioButton area_35 = new JRadioButton("경상북도");
	private JRadioButton area_36 = new JRadioButton("경상남도");
	private JRadioButton area_37 = new JRadioButton("전라북도");
	private JRadioButton area_38 = new JRadioButton("전라남도");
	private JRadioButton area_39 = new JRadioButton("제주도");
	private JRadioButton earea_1 = new JRadioButton("서울");
	private JRadioButton earea_2 = new JRadioButton("인천");
	private JRadioButton earea_3 = new JRadioButton("대전");
	private JRadioButton earea_4 = new JRadioButton("대구");
	private JRadioButton earea_5 = new JRadioButton("광주");
	private JRadioButton earea_6 = new JRadioButton("부산");
	private JRadioButton earea_7 = new JRadioButton("울산");
	private JRadioButton earea_8 = new JRadioButton("세종특별자치시");
	private JRadioButton earea_31 = new JRadioButton("경기도");
	private JRadioButton earea_32 = new JRadioButton("강원도");
	private JRadioButton earea_33 = new JRadioButton("충청북도");
	private JRadioButton earea_34 = new JRadioButton("충청남도");
	private JRadioButton earea_35 = new JRadioButton("경상북도");
	private JRadioButton earea_36 = new JRadioButton("경상남도");
	private JRadioButton earea_37 = new JRadioButton("전라북도");
	private JRadioButton earea_38 = new JRadioButton("전라남도");
	private JRadioButton earea_39 = new JRadioButton("제주도");
	private JRadioButton harea_1 = new JRadioButton("서울");
	private JRadioButton harea_2 = new JRadioButton("인천");
	private JRadioButton harea_3 = new JRadioButton("대전");
	private JRadioButton harea_4 = new JRadioButton("대구");
	private JRadioButton harea_5 = new JRadioButton("광주");
	private JRadioButton harea_6 = new JRadioButton("부산");
	private JRadioButton harea_7 = new JRadioButton("울산");
	private JRadioButton harea_8 = new JRadioButton("세종특별자치시");
	private JRadioButton harea_31 = new JRadioButton("경기도");
	private JRadioButton harea_32 = new JRadioButton("강원도");
	private JRadioButton harea_33 = new JRadioButton("충청북도");
	private JRadioButton harea_34 = new JRadioButton("충청남도");
	private JRadioButton harea_35 = new JRadioButton("경상북도");
	private JRadioButton harea_36 = new JRadioButton("경상남도");
	private JRadioButton harea_37 = new JRadioButton("전라북도");
	private JRadioButton harea_38 = new JRadioButton("전라남도");
	private JRadioButton harea_39 = new JRadioButton("제주도");
	
	private Vector ninfo_data;
	private Vector einfo_data;
	private Vector hinfo_data;
	private JList nlist;
	private JList elist;
	private JList hlist;
	private JList list;
	
	String areaName ="";
	String bmkContId = "";
	int bmkContId_int;
	
	private ButtonGroup areaGroup =new ButtonGroup();
		
	private ResultSet rs;
	
	String query;
	String name;
	String reg_no;
	String id;
	String pwd;
	String address;
	static int cont=0;
	private JPanel mainPage;
	private final JPanel ninfoPage = new JPanel();
	private final JLabel ninfoAddressLabel = new JLabel("Address");
	private final JLabel ninfoOverviewLabel = new JLabel("Overview");
	private final JTextPane ninfoTitleText = new JTextPane();
	
	private final JButton ebookmarkBtn = new JButton("즐겨찾기");
	private final JButton evisotrBtn = new JButton("방문");
	private final JButton expInfo_out = new JButton("BACK");
	private final JTextPane einfoAddressText = new JTextPane();
	private final JLabel einfoIMG = new JLabel("no img");
	private final JLabel einfoAddressLabel = new JLabel("Address");
	private final JLabel einfoOverviewLabel = new JLabel("Overview");
	private final JTextPane einfoOverviewText = new JTextPane();
	private final JTextPane einfoTitleText = new JTextPane();
	
	private final JButton hbookmarkBtn = new JButton("즐겨찾기");
	private final JButton hvisotrBtn = new JButton("방문");
	private final JPanel hisinfoPage = new JPanel();
	private final JButton hisInfo_out = new JButton("BACK");
	private final JTextPane hinfoAddressText = new JTextPane();
	private final JLabel hinfoIMG = new JLabel("no img");
	private final JTextPane hinfoTitleText = new JTextPane();
	private final JLabel hinfoAddressLabel = new JLabel("Address");
	private final JLabel hinfoOverviewLabel = new JLabel("Overview");
	private final JTextPane hinfoOverviewText = new JTextPane();
	private final JButton cancel = new JButton("Cancel");
	private final JList list_1 = new JList();
	
	public Start() {
		
		ImageDown down = new ImageDown();
		DAO dao= new DAO();
		dao.connDB();
				//areaButtonSetting_his end
						
//Member_no reset		
				
		setSize(1150, 520);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
//login page
		JPanel loginPage = new JPanel();
		currentPage = loginPage;
		currentPage.setVisible(true);
		
		//
		ninfoPage.add(ninfoPanel);
		
		
		JButton ninfoBackBtn = new JButton("BACK");
		ninfoBackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				currentPage.setVisible(false);
				currentPage = naturePage;
				currentPage.setVisible(true);
			}
		});
		ninfoBackBtn.setBounds(24, 444, 110, 34);
		ninfoPanel.add(ninfoBackBtn);
		
		
		ninfoAddressText.setBounds(561, 149, 579, 48);
		ninfoAddressText.isEditable();
								expinfoPage.add(einfoPanel);
								expInfo_out.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										currentPage.setVisible(false);
										currentPage = expPage;
										currentPage.setVisible(true);
									}
								});
								expInfo_out.setBounds(24, 448, 97, 32);
								
								einfoPanel.add(expInfo_out);
								einfoAddressText.setEditable(false);
								einfoAddressText.setBounds(561, 149, 579, 48);
								
								einfoPanel.add(einfoAddressText);
								einfoIMG.setBounds(163, 10, 280, 337);
								
								einfoPanel.add(einfoIMG);
								einfoTitleText.setFont(new Font("굴림", Font.BOLD, 30));
								einfoTitleText.setEditable(false);
								einfoTitleText.setBounds(461, 23, 649, 89);
								
								einfoPanel.add(einfoTitleText);
								einfoAddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
								einfoAddressLabel.setFont(new Font("굴림", Font.BOLD, 20));
								einfoAddressLabel.setBounds(455, 130, 103, 55);
								
								einfoPanel.add(einfoAddressLabel);
								einfoOverviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
								einfoOverviewLabel.setFont(new Font("굴림", Font.BOLD, 21));
								einfoOverviewLabel.setBounds(445, 220, 115, 63);
								
								einfoPanel.add(einfoOverviewLabel);
								einfoOverviewText.setEditable(false);
								einfoOverviewText.setBounds(561, 220, 579, 236);
								
								einfoPanel.add(einfoOverviewText);
								expinfoPage.setVisible(false);
				hisinfoPage.add(hinfoPanel);
				hisinfoPage.setVisible(false);
				hisInfo_out.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = hisPage;
						currentPage.setVisible(true);
					}
				});
				
				areaGroup.add(earea_1);
				areaGroup.add(earea_2);
				areaGroup.add(earea_3);
				areaGroup.add(earea_4);
				areaGroup.add(earea_5);
				areaGroup.add(earea_6);
				areaGroup.add(earea_7);
				areaGroup.add(earea_8);
				areaGroup.add(earea_31);
				areaGroup.add(earea_32);
				areaGroup.add(earea_33);
				areaGroup.add(earea_34);
				areaGroup.add(earea_35);
				areaGroup.add(earea_36);
				areaGroup.add(earea_37);
				areaGroup.add(earea_38);
				areaGroup.add(earea_39);
				//areaButtonSetting_nature end
				
//areaButtonSetting_exp
						earea_1.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_1.getText();
							  }
						});
						
						earea_1.setBounds(161, 60, 121, 23);
						expPanel.add(earea_1);
						
						earea_2.setBounds(161, 85, 121, 23);
						earea_2.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_2.getText();
							}
						});
						expPanel.add(earea_2);
						
						earea_3.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_3.getText();
							}
						});
						expPanel.add(earea_3);
						earea_3.setBounds(161, 110, 121, 23);
						
						earea_4.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_4.getText();
							}
						});
						expPanel.add(earea_4);
						earea_4.setBounds(161, 135, 121, 23);
						
						earea_5.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_5.getText();
							}
						});
						expPanel.add(earea_5);
						earea_5.setBounds(161, 160, 121, 23);
						
						earea_6.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_6.getText();
							}
						});
						expPanel.add(earea_6);
						earea_6.setBounds(161, 185, 121, 23);
						
						earea_7.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_7.getText();
							}
						});
						expPanel.add(earea_7);
						earea_7.setBounds(161, 210, 121, 23);
						
						earea_8.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_8.getText();
							}
						});
						expPanel.add(earea_8);
						earea_8.setBounds(161, 235, 121, 23);
						
						earea_31.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_31.getText();
							}
						});
						expPanel.add(earea_31);
						earea_31.setBounds(161, 260, 121, 23);
						
						earea_32.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_32.getText();
							}
						});
						expPanel.add(earea_32);
						earea_32.setBounds(286, 60, 121, 23);
						
						earea_33.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_33.getText();
							}
						});
						expPanel.add(earea_33);
						earea_33.setBounds(286, 85, 121, 23);
						
						earea_34.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_34.getText();
							}
						});
						expPanel.add(earea_34);
						earea_34.setBounds(286, 110, 121, 23);
						
						earea_35.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_35.getText();
							}
						});
						expPanel.add(earea_35);
						earea_35.setBounds(286, 135, 121, 23);
						
						earea_36.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_36.getText();
							}
						});
						expPanel.add(earea_36);
						earea_36.setBounds(286, 160, 121, 23);
						
						earea_37.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_37.getText();
							}
						});
						expPanel.add(earea_37);
						earea_37.setBounds(286, 185, 121, 23);
						
						earea_38.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_38.getText();
							}
						});
						expPanel.add(earea_38);
						earea_38.setBounds(286, 210, 121, 23);
						
						earea_39.addMouseListener(new MouseAdapter() {
							public void mouseClicked(MouseEvent arg0) {
								areaName = earea_39.getText();
								
							}
						});
						expPanel.add(earea_39);
						earea_39.setBounds(286, 235, 121, 23);
						
		//exp_searchBtn		
						JButton exp_searchBtn = new JButton("search");
						exp_searchBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								einfo_data=dao.searchE(areaName);
								elist.setListData(einfo_data);
							}
						});
						exp_searchBtn.setBounds(235, 302, 97, 38);
						expPanel.add(exp_searchBtn);
						
						elist = new JList();
						elist.addListSelectionListener(new ListSelectionListener() {
							public void valueChanged(ListSelectionEvent e) {
								sel = elist.getSelectedValue().toString();
								System.out.println(sel);
							}
						});
						JScrollPane exp_list = new JScrollPane(elist);
						exp_list.setBounds(12, 10, 475, 448);
						exp_list.setPreferredSize(new Dimension(475,448));
						expP_search.add(exp_list);
						
						expP_search.setBounds(415, 10, 723, 468);
						expPanel.add(expP_search);
						expP_search.setLayout(null);
						JButton eselectBtn = new JButton("선택");
						eselectBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dao.infomation(dao.contIdInfo(sel));
								Parsing parsing = new Parsing();
								parsing.address();
								parsing.overview();
								einfoTitleText.setText(sel);
								einfoAddressText.setText(parsing.address);
								einfoOverviewText.setText(parsing.overview);
												
							 	down.downloadImg();
							 	einfoIMG.setIcon(down.getImg());
							 	down.fileDelete("./location");
								
								currentPage.setVisible(false);
								currentPage = expinfoPage;
								currentPage.setVisible(true);
							}
						});
						eselectBtn.setBounds(540, 134, 147, 50);
						
						expP_search.add(eselectBtn);
						ebookmarkBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								dao.bookmark(currentUser, dao.contIdInfo(sel));
							}
						});
						areaGroup.add(harea_1);
						areaGroup.add(harea_2);
						areaGroup.add(harea_3);
						areaGroup.add(harea_4);
						areaGroup.add(harea_5);
						areaGroup.add(harea_6);
						areaGroup.add(harea_7);
						areaGroup.add(harea_8);
						areaGroup.add(harea_31);
						areaGroup.add(harea_32);
						areaGroup.add(harea_33);
						areaGroup.add(harea_34);
						areaGroup.add(harea_35);
						areaGroup.add(harea_36);
						areaGroup.add(harea_37);
						areaGroup.add(harea_38);
						areaGroup.add(harea_39);
						//areaButtonSetting_exp end		
		
//areaButtonSetting_his 
				harea_1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_1.getText();
					  }
				});
				
				harea_1.setBounds(161, 60, 121, 23);
				hisPanel.add(harea_1);
				
				harea_2.setBounds(161, 85, 121, 23);
				harea_2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_2.getText();
					}
				});
				hisPanel.add(harea_2);
				
				harea_3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_3.getText();
					}
				});
				hisPanel.add(harea_3);
				harea_3.setBounds(161, 110, 121, 23);
				
				harea_4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_4.getText();
					}
				});
				hisPanel.add(harea_4);
				harea_4.setBounds(161, 135, 121, 23);
				
				harea_5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_5.getText();
					}
				});
				hisPanel.add(harea_5);
				harea_5.setBounds(161, 160, 121, 23);
				
				harea_6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_6.getText();
					}
				});
				hisPanel.add(harea_6);
				harea_6.setBounds(161, 185, 121, 23);
				
				harea_7.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_7.getText();
					}
				});
				hisPanel.add(harea_7);
				harea_7.setBounds(161, 210, 121, 23);
				
				harea_8.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_8.getText();
					}
				});
				hisPanel.add(harea_8);
				harea_8.setBounds(161, 235, 121, 23);
				
				harea_31.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_31.getText();
					}
				});
				hisPanel.add(harea_31);
				harea_31.setBounds(161, 260, 121, 23);
				
				harea_32.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_32.getText();
					}
				});
				hisPanel.add(harea_32);
				harea_32.setBounds(286, 60, 121, 23);
				
				harea_33.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_33.getText();
					}
				});
				hisPanel.add(harea_33);
				harea_33.setBounds(286, 85, 121, 23);
				
				harea_34.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_34.getText();
					}
				});
				hisPanel.add(harea_34);
				harea_34.setBounds(286, 110, 121, 23);
				
				harea_35.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_35.getText();
					}
				});
				hisPanel.add(harea_35);
				harea_35.setBounds(286, 135, 121, 23);
				
				harea_36.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_36.getText();
					}
				});
				hisPanel.add(harea_36);
				harea_36.setBounds(286, 160, 121, 23);
				
				harea_37.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_37.getText();
					}
				});
				hisPanel.add(harea_37);
				harea_37.setBounds(286, 185, 121, 23);
				
				harea_38.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_38.getText();
					}
				});
				hisPanel.add(harea_38);
				harea_38.setBounds(286, 210, 121, 23);
				
				harea_39.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = harea_39.getText();
						
					}
				});
				hisPanel.add(harea_39);
				harea_39.setBounds(286, 235, 121, 23);
				
		   //his_searchBtn		
				JButton his_searchBtn = new JButton("search");
				his_searchBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						hinfo_data=dao.searchH(areaName);
						hlist.setListData(hinfo_data);
					}
				});
				his_searchBtn.setBounds(235, 302, 97, 38);
				hisPanel.add(his_searchBtn);
				
				hlist = new JList();
				hlist.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						sel = hlist.getSelectedValue().toString();
						System.out.println(sel);
					}
				});
				JScrollPane his_list = new JScrollPane(hlist);
				his_list.setBounds(12, 10, 475, 448);
				his_list.setPreferredSize(new Dimension(475,448));
				hisP_search.add(his_list);
				
				hisP_search.setBounds(415, 10, 723, 468);
				hisPanel.add(hisP_search);
				hisP_search.setLayout(null);
				JButton hselectBtn = new JButton("선택");
				hselectBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 Parsing parsing = new Parsing();
							dao.infomation(dao.contIdInfo(sel));
							parsing.address();
							parsing.overview();
							hinfoTitleText.setText(sel);
							hinfoAddressText.setText(parsing.address);
							hinfoOverviewText.setText(parsing.overview);
											
						 	down.downloadImg();
						 	hinfoIMG.setIcon(down.getImg());
						 	down.fileDelete("./location");
						 	
						currentPage.setVisible(false);
						currentPage = hisinfoPage;
						currentPage.setVisible(true);
					}
				});
				hselectBtn.setBounds(540, 134, 147, 50);
				
				hisP_search.add(hselectBtn);
				hbookmarkBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dao.bookmark(currentUser, dao.contIdInfo(sel));
					}
				});
				
//register page
				JPanel regPage = new JPanel();
				regPage.setVisible(false);
				regPage.add(regPanel);
				regPage.setBounds(0, 0, 1144, 480);
				getContentPane().add(regPage);
				regPage.setLayout(null);
				regPanel.setBounds(0, 0, 1150, 480);
				
				
				regName = new JTextField();
				regName.setFont(new Font("굴림", Font.PLAIN, 18));
				regName.setBounds(149, 203, 245, 30);
				regName.setBorder(null);
				regPanel.add(regName);
				regName.setColumns(10);
				
				regId = new JTextField();
				regId.setFont(new Font("굴림", Font.PLAIN, 18));
				regId.setColumns(10);
				regId.setBounds(149, 266, 245, 30);
				regId.setBorder(null);
				regPanel.add(regId);
				
				regPwd = new JPasswordField();
				regPwd.setColumns(10);
				regPwd.setBounds(569, 260, 245, 30);
				regPwd.setBorder(null);
				regPanel.add(regPwd);
				
				regNo = new JTextField();
				regNo.setFont(new Font("굴림", Font.PLAIN, 18));
				regNo.setBounds(608, 203, 193, 30);
				regNo.setBorder(null);
				regPanel.add(regNo);
				regNo.setColumns(10);
				
				regAdd = new JTextField();
				regAdd.setFont(new Font("Gulim", Font.PLAIN, 12));
				regAdd.setBounds(149, 319, 892, 30);
				regAdd.setBorder(null);
				regPanel.add(regAdd);
				regAdd.setColumns(10);
				
				//확인버튼
				JButton confirm = new JButton("확인");
				
				
				confirm.setFont(new Font("굴림", Font.BOLD, 27));
				confirm.setBounds(338, 383, 168, 56);
				regPanel.add(confirm);
				
				JButton back = new JButton("뒤로가기");
				back.setFont(new Font("굴림", Font.BOLD, 27));
				
				back.setBounds(569, 383, 168, 56);
				regPanel.add(back);
				
							
						
								//뒤로가기버튼 이벤트
								back.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent arg0) {
										currentPage.setVisible(false);
										currentPage = loginPage;
										currentPage.setVisible(true);
									}
								});
								
								//확인버튼 이벤트(회원가입)
										confirm.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent arg0) {
												name = regName.getText();
												reg_no = regNo.getText();
												id = regId.getText();
												pwd = regPwd.getText();
												address = regAdd.getText();
												boolean regCheck = false; //주민번호에 숫자만
												
												for(int i=0;i<reg_no.length();i++) {
													if(reg_no.charAt(i)<'0' || reg_no.charAt(i)>='9') {
														regCheck = false;
													}else {
														regCheck = true;
													}
												}
												
												
												if(dao.checkId(id)) {//checkid
													if(regCheck) {//regcheck
													   if(reg_no.length()==13) {//check13
														  dao.register(name, reg_no, id, pwd, address);
														   }//check13
													   	else {
														   JOptionPane.showMessageDialog(null, "- 를 제외한 13자리 주민번호를 입력하세요.");
														   }
													}//regcheck
													else {
														JOptionPane.showMessageDialog(null, "주민번호에 숫자를 입력하세요");
													}
												}//check id
												else {
													JOptionPane.showMessageDialog(null, "중복된 아이디 입니다.");
												}
												
												regName.setText("");			
												regNo.setText("");			
												regId.setText("");			
												regPwd.setText("");			
												regAdd.setText("");			
												
												currentPage.setVisible(false);
												currentPage = loginPage;
												currentPage.setVisible(true);
																		
											}
										});
				
//bookmarkPage		
				bookmarkPage = new JPanel();
				
				
				bookmarkPage.setBounds(0, 0, 1144, 491);
				getContentPane().add(bookmarkPage);
				bookmarkPage.setLayout(null);
				bookmarkPage.add(bookmarkPanel);
				bookmarkPage.setVisible(false);
				
//bookmarkPage Button
				JButton bookmark_expBtn = new JButton("New button");
				bookmark_expBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = expPage;
						currentPage.setVisible(true);
					}
				});
				bookmark_expBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnExp.jpg"));
				bookmark_expBtn.setBorder(null);
				bookmark_expBtn.setBounds(12, 164, 135, 32);
				bookmarkPanel.add(bookmark_expBtn);
				
				
				JButton bookmark_hisBtn = new JButton("New button");
				bookmark_hisBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = hisPage;
						currentPage.setVisible(true);
					}
				});
				bookmark_hisBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnHis.jpg"));
				bookmark_hisBtn.setBorder(null);
				bookmark_hisBtn.setBounds(12, 216, 122, 38);
				bookmarkPanel.add(bookmark_hisBtn);
				
				JButton bookmark_natureBtn = new JButton("New button");
				bookmark_natureBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = naturePage;
						currentPage.setVisible(true);
					}
				});
				bookmark_natureBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\MainBtnNature.jpg"));
				bookmark_natureBtn.setBorder(null);
				bookmark_natureBtn.setBounds(12, 84, 122, 47);
				bookmarkPanel.add(bookmark_natureBtn);
				
				JButton bookmark_achieveBtn = new JButton("New button");
				bookmark_achieveBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = achievePage;
						currentPage.setVisible(true);
					}
				});
				bookmark_achieveBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnAchieve.jpg"));
				bookmark_achieveBtn.setBorder(null);
				bookmark_achieveBtn.setBounds(12, 361, 122, 38);
				bookmarkPanel.add(bookmark_achieveBtn);
				
				JButton bookmark_out = new JButton("OUT");
				bookmark_out.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = mainPage;
						currentPage.setVisible(true);
					}
				});
				bookmark_out.setBounds(23, 446, 97, 32);
				bookmarkPanel.add(bookmark_out);
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bmkContId = "";
						dao.cancel(bmkContId_int);
						list_1.setListData(dao.bookmarkInfo(currentUser));
					
					}
				});
				cancel.setBounds(786, 224, 135, 30);
				
				bookmarkPanel.add(cancel);
				list_1.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						//System.out.println(list_1.getSelectedValuesList().toString());
						String a = list_1.getSelectedValuesList().toString();
						String temp ="";
												
						for(int i=0;i<a.length();i++) {
							temp = a.substring(i,i+1);
							if(Character.isDigit(a.charAt(i))) {
								bmkContId += temp;
							}
						}
						
					bmkContId_int = Integer.parseInt(bmkContId);
					bmkContId = "";				
					}
				});
							
				JScrollPane bookScroll = new JScrollPane(list_1);
				bookScroll.setBounds(353, 39, 361, 439);
				bookmarkPanel.add(bookScroll);
				bookScroll.setPreferredSize(new Dimension(475,448));
				list_1.setBounds(0, 0, 1, 1);
				
				
//naturePage		
				naturePage = new JPanel();
				naturePage.setBounds(0, 0, 1144, 491);
				getContentPane().add(naturePage);
				naturePage.setLayout(null);
				
				areaGroup.add(area_1);
				areaGroup.add(area_2);
				areaGroup.add(area_3);
				areaGroup.add(area_4);
				areaGroup.add(area_5);
				areaGroup.add(area_6);
				areaGroup.add(area_7);
				areaGroup.add(area_8);
				areaGroup.add(area_31);
				areaGroup.add(area_32);
				areaGroup.add(area_33);
				areaGroup.add(area_34);
				areaGroup.add(area_35);
				areaGroup.add(area_36);
				areaGroup.add(area_37);
				areaGroup.add(area_38);
				areaGroup.add(area_39);
				
//areaButtonSetting
				area_1.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_1.getText();
					  }
				});
				
				nlist = new JList();
				nlist.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent e) {
						sel = nlist.getSelectedValue().toString();
						
					}
				});
				JScrollPane nature_list = new JScrollPane(nlist);
				nature_list.setBounds(12, 10, 475, 448);
				nature_list.setPreferredSize(new Dimension(475,448));
				natureP_search.add(nature_list);
				
				natureP_search.setBounds(415, 10, 723, 468);
				naturePanel.add(natureP_search);
				natureP_search.setLayout(null);
				
					
				JButton nselectBtn = new JButton("선택");
				nselectBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					  Parsing parsing = new Parsing();
						dao.infomation(dao.contIdInfo(sel));
						parsing.address();
						parsing.overview();
						ninfoTitleText.setText(sel);
						ninfoAddressText.setText(parsing.address);
						ninfoOverviewText.setText(parsing.overview);
										
					 	down.downloadImg();
					 	ninfoIMG.setIcon(down.getImg());
					 	down.fileDelete("./location");
						
					 				 	
						currentPage.setVisible(false);
						currentPage = ninfoPage;
						currentPage.setVisible(true);
						
						
					}
				});
				nselectBtn.setBounds(540, 134, 147, 50);
				natureP_search.add(nselectBtn);
				
				JButton nbookmarkBtn = new JButton("즐겨찾기");
				nbookmarkBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dao.bookmark(currentUser, dao.contIdInfo(sel));
					}
				});
				nbookmarkBtn.setBounds(540, 230, 147, 50);
				natureP_search.add(nbookmarkBtn);
				
				JButton visotrBtn = new JButton("방문");
				visotrBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				visotrBtn.setBounds(540, 328, 147, 50);
				natureP_search.add(visotrBtn);
				
				area_1.setBounds(161, 60, 121, 23);
				naturePanel.add(area_1);
				
				area_2.setBounds(161, 85, 121, 23);
				area_2.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_2.getText();
					}
				});
				naturePanel.add(area_2);
				
				area_3.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_3.getText();
					}
				});
				naturePanel.add(area_3);
				area_3.setBounds(161, 110, 121, 23);
				
				area_4.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_4.getText();
					}
				});
				naturePanel.add(area_4);
				area_4.setBounds(161, 135, 121, 23);
				
				area_5.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_5.getText();
					}
				});
				naturePanel.add(area_5);
				area_5.setBounds(161, 160, 121, 23);
				
				area_6.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_6.getText();
					}
				});
				naturePanel.add(area_6);
				area_6.setBounds(161, 185, 121, 23);
				
				area_7.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_7.getText();
					}
				});
				naturePanel.add(area_7);
				area_7.setBounds(161, 210, 121, 23);
				
				area_8.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_8.getText();
					}
				});
				naturePanel.add(area_8);
				area_8.setBounds(161, 235, 121, 23);
				
				area_31.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_31.getText();
					}
				});
				naturePanel.add(area_31);
				area_31.setBounds(161, 260, 121, 23);
				
				area_32.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_32.getText();
					}
				});
				naturePanel.add(area_32);
				area_32.setBounds(286, 60, 121, 23);
				
				area_33.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_33.getText();
					}
				});
				naturePanel.add(area_33);
				area_33.setBounds(286, 85, 121, 23);
				
				area_34.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_34.getText();
					}
				});
				naturePanel.add(area_34);
				area_34.setBounds(286, 110, 121, 23);
				
				area_35.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_35.getText();
					}
				});
				naturePanel.add(area_35);
				area_35.setBounds(286, 135, 121, 23);
				
				area_36.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_36.getText();
					}
				});
				naturePanel.add(area_36);
				area_36.setBounds(286, 160, 121, 23);
				
				area_37.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_37.getText();
					}
				});
				naturePanel.add(area_37);
				area_37.setBounds(286, 185, 121, 23);
				
				area_38.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_38.getText();
					}
				});
				naturePanel.add(area_38);
				area_38.setBounds(286, 210, 121, 23);
				
				area_39.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent arg0) {
						areaName = area_39.getText();
						
					}
				});
				naturePanel.add(area_39);
				area_39.setBounds(286, 235, 121, 23);
				
   //nature_searchBtn		
				JButton btnNewButton = new JButton("search");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ninfo_data=dao.searchN(areaName);
						nlist.setListData(ninfo_data);
						System.out.println(currentUser);
					}
				});
				btnNewButton.setBounds(235, 302, 97, 38);
				naturePanel.add(btnNewButton);
				naturePage.add(naturePanel);
				
				//naturePageButton		
						JButton nature_expBtn = new JButton("New button");
						nature_expBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = expPage;
								currentPage.setVisible(true);
							}
						});
						nature_expBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnExp.jpg"));
						nature_expBtn.setBorder(null);
						nature_expBtn.setBounds(12, 164, 135, 32);
						naturePanel.add(nature_expBtn);
						
						
						JButton nature_hisBtn = new JButton("New button");
						nature_hisBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = hisPage;
								currentPage.setVisible(true);
							}
						});
						nature_hisBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnHis.jpg"));
						nature_hisBtn.setBorder(null);
						nature_hisBtn.setBounds(12, 216, 122, 38);
						naturePanel.add(nature_hisBtn);
						
						JButton nature_bookmarkBtn = new JButton("New button");
						nature_bookmarkBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								list_1.setListData(dao.bookmarkInfo(currentUser));
								
								currentPage.setVisible(false);
								currentPage = bookmarkPage;
								currentPage.setVisible(true);
							}
						});
						nature_bookmarkBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnBookmark.jpg"));
						nature_bookmarkBtn.setBorder(null);
						nature_bookmarkBtn.setBounds(8, 302, 143, 38);
						naturePanel.add(nature_bookmarkBtn);
						
						JButton nature_achieveBtn = new JButton("New button");
						nature_achieveBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = achievePage;
								currentPage.setVisible(true);
							}
						});
						nature_achieveBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnAchieve.jpg"));
						nature_achieveBtn.setBorder(null);
						nature_achieveBtn.setBounds(12, 361, 122, 38);
						naturePanel.add(nature_achieveBtn);
						
						JButton nature_out = new JButton("OUT");
						nature_out.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = mainPage;
								currentPage.setVisible(true);
							}
						});
						nature_out.setBounds(23, 446, 97, 32);
						naturePanel.add(nature_out);
						nature_bookmarkBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = bookmarkPage;
								currentPage.setVisible(true);
							}
						});
						nature_out.setBounds(23, 446, 97, 32);
						naturePage.setVisible(false);
				hbookmarkBtn.setBounds(540, 230, 147, 50);
				
				hisP_search.add(hbookmarkBtn);
				hvisotrBtn.setBounds(540, 328, 147, 50);
				
				hisP_search.add(hvisotrBtn);
				
//hisPage		
				hisPage = new JPanel();
				hisPage.setBounds(0, 0, 1144, 491);
				getContentPane().add(hisPage);
				hisPage.setLayout(null);
				hisPage.add(hisPanel);
				hisPage.setVisible(false);
				
				//HistoryPage button
						JButton history_expBtn = new JButton("New button");
						history_expBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = expPage;
								currentPage.setVisible(true);
							}
						});
						history_expBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnExp.jpg"));
						history_expBtn.setBorder(null);
						history_expBtn.setBounds(12, 164, 135, 32);
						hisPanel.add(history_expBtn);
						
						
						JButton history_natureBtn = new JButton("New button");
						history_natureBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = naturePage;
								currentPage.setVisible(true);
							}
						});
						history_natureBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\MainBtnNature.jpg"));
						history_natureBtn.setBorder(null);
						history_natureBtn.setBounds(12, 84, 122, 47);
						hisPanel.add(history_natureBtn);
						
						JButton history_bookmarkBtn = new JButton("New button");
						history_bookmarkBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnBookmark.jpg"));
						history_bookmarkBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								list_1.setListData(dao.bookmarkInfo(currentUser));
								currentPage.setVisible(false);
								currentPage = bookmarkPage;
								currentPage.setVisible(true);
							}
						});
						history_bookmarkBtn.setBorder(null);
						history_bookmarkBtn.setBounds(8, 302, 143, 38);
						hisPanel.add(history_bookmarkBtn);
						
						JButton history_achieveBtn = new JButton("New button");
						history_achieveBtn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = achievePage;
								currentPage.setVisible(true);
							}
						});
						history_achieveBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnAchieve.jpg"));
						history_achieveBtn.setBorder(null);
						history_achieveBtn.setBounds(12, 361, 122, 38);
						hisPanel.add(history_achieveBtn);
						
						JButton history_out = new JButton("OUT");
						history_out.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								currentPage.setVisible(false);
								currentPage = mainPage;
								currentPage.setVisible(true);
							}
						});
						history_out.setBounds(25, 447, 97, 32);
						hisPanel.add(history_out);		
						ebookmarkBtn.setBounds(540, 230, 147, 50);
						
						expP_search.add(ebookmarkBtn);
						evisotrBtn.setBounds(540, 328, 147, 50);
						
						expP_search.add(evisotrBtn);
						
//expPage
							expPage = new JPanel();
							expPage.setBounds(0, 0, 1144, 491);
							getContentPane().add(expPage);
							expPage.setLayout(null);
							expPage.add(expPanel);
							
							
//expPageButton
							JButton exp_natureBtn = new JButton("New button");
							exp_natureBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									currentPage.setVisible(false);
									currentPage = naturePage;
									currentPage.setVisible(true);
								}
							});
							exp_natureBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\MainBtnNature.jpg"));
							exp_natureBtn.setBorder(null);
							exp_natureBtn.setBounds(12, 84, 122, 47);
							expPanel.add(exp_natureBtn);
							
							
							JButton exp_hisBtn = new JButton("New button");
							exp_hisBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									currentPage.setVisible(false);
									currentPage = hisPage;
									currentPage.setVisible(true);
								}
							});
							exp_hisBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnHis.jpg"));
							exp_hisBtn.setBorder(null);
							exp_hisBtn.setBounds(12, 216, 122, 38);
							expPanel.add(exp_hisBtn);
							
							JButton exp_bookmarkBtn = new JButton("New button");
							exp_bookmarkBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									
									list_1.setListData(dao.bookmarkInfo(currentUser));
									currentPage.setVisible(false);
									currentPage = bookmarkPage;
									currentPage.setVisible(true);
								}
							});
							exp_bookmarkBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnBookmark.jpg"));
							exp_bookmarkBtn.setBorder(null);
							exp_bookmarkBtn.setBounds(8, 302, 143, 38);
							expPanel.add(exp_bookmarkBtn);
							
							JButton exp_achieveBtn = new JButton("New button");
							exp_achieveBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									currentPage.setVisible(false);
									currentPage = achievePage;
									currentPage.setVisible(true);
								}
							});
							exp_achieveBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnAchieve.jpg"));
							exp_achieveBtn.setBorder(null);
							exp_achieveBtn.setBounds(12, 361, 122, 38);
							expPanel.add(exp_achieveBtn);
							
							JButton exp_out = new JButton("OUT");
							exp_out.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									currentPage.setVisible(false);
									currentPage = mainPage;
									currentPage.setVisible(true);
								}
							});
							exp_out.setBounds(23, 446, 97, 32);
							expPanel.add(exp_out);
							exp_natureBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									currentPage.setVisible(false);
									currentPage = naturePage;
									currentPage.setVisible(true);
								}
							});
							exp_natureBtn.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									currentPage.setVisible(false);
									currentPage = naturePage;
									currentPage.setVisible(true);
								}
							});
							expPage.setVisible(false);
				hisInfo_out.setBounds(25, 446, 97, 32);
				
				hinfoPanel.add(hisInfo_out);
				hinfoAddressText.setEditable(false);
				hinfoAddressText.setBounds(561, 149, 579, 48);
				
				hinfoPanel.add(hinfoAddressText);
				hinfoIMG.setBounds(163, 10, 280, 337);
				
				hinfoPanel.add(hinfoIMG);
				hinfoTitleText.setFont(new Font("굴림", Font.BOLD, 30));
				hinfoTitleText.setEditable(false);
				hinfoTitleText.setBounds(461, 23, 649, 89);
				
				hinfoPanel.add(hinfoTitleText);
				hinfoAddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
				hinfoAddressLabel.setFont(new Font("굴림", Font.BOLD, 20));
				hinfoAddressLabel.setBounds(455, 130, 103, 55);
				
				hinfoPanel.add(hinfoAddressLabel);
				hinfoOverviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				hinfoOverviewLabel.setFont(new Font("굴림", Font.BOLD, 21));
				hinfoOverviewLabel.setBounds(445, 220, 115, 63);
				
				hinfoPanel.add(hinfoOverviewLabel);
				hinfoOverviewText.setEditable(false);
				hinfoOverviewText.setBounds(561, 220, 579, 236);
				
				hinfoPanel.add(hinfoOverviewText);
				hisinfoPage.setBounds(0, 0, 1144, 491);
				
				getContentPane().add(hisinfoPage);
				hisinfoPage.setLayout(null);
								
								
								expinfoPage.setBounds(0, -5, 1144, 491);
								getContentPane().add(expinfoPage);
								expinfoPage.setLayout(null);
		ninfoAddressText.setEditable(false);
		ninfoPanel.add(ninfoAddressText);
		
		
		ninfoIMG.setBounds(163, 10, 280, 337);
		ninfoPanel.add(ninfoIMG);
		ninfoAddressLabel.setFont(new Font("굴림", Font.BOLD, 20));
		ninfoAddressLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ninfoAddressLabel.setBounds(455, 130, 103, 55);
		
		ninfoPanel.add(ninfoAddressLabel);
		ninfoOverviewLabel.setFont(new Font("굴림", Font.BOLD, 21));
		ninfoOverviewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ninfoOverviewLabel.setBounds(445, 220, 115, 63);
		
		ninfoPanel.add(ninfoOverviewLabel);
		
		
		ninfoOverviewText.setEditable(false);
		ninfoOverviewText.setBounds(561, 220, 579, 236);
		ninfoPanel.add(ninfoOverviewText);
		ninfoTitleText.setFont(new Font("굴림", Font.BOLD, 30));
		ninfoTitleText.setEditable(false);
		ninfoTitleText.setBounds(462, 23, 649, 89);
		
		ninfoPanel.add(ninfoTitleText);
		ninfoPage.setBounds(0, -5, 1144, 491);
		getContentPane().add(ninfoPage);
		ninfoPage.setVisible(false);
		
		
		loginPage.setBounds(0, 0, 1144, 480);
		getContentPane().add(loginPage);
		loginPage.setLayout(null);
		panel.setBounds(0, 0, 1150, 480);
		loginPage.add(panel);
		
				
		idField = new JTextField();
		idField.setFont(new Font("돋움", Font.BOLD, 15));
		idField.setBounds(141, 214, 245, 30);
		idField.setBorder(null);
		panel.add(idField);
		idField.setColumns(10);
		
		pwdField = new JPasswordField();
		pwdField.setFont(new Font("굴림", Font.BOLD, 15));
		pwdField.setBounds(141, 310, 245, 30);
		pwdField.setBorder(null);
		panel.add(pwdField);
		currentPage = loginPage;
		
		    //로그인버튼
		JButton logBtn = new JButton("");
		
		
		logBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\loginbtn.jpg"));
		logBtn.setSelectedIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\login.jpg"));
		logBtn.setPressedIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\clicklogin.jpg"));
		logBtn.setBorder(null);
		logBtn.setBounds(229, 379, 157, 35);
		panel.add(logBtn);
		
		
		   //회원가입버튼
		JButton regBtn = new JButton("");
		regBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\reg.jpg"));
		regBtn.setSelectedIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\reg.jpg"));
		regBtn.setPressedIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\clickreg.jpg"));
		regBtn.setBorder(null);
		
		regBtn.setBounds(56, 379, 161, 35);
		panel.add(regBtn);
		getContentPane().add(loginPage);
		
		//회원가입버튼 이벤트
		regBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage.setVisible(false);
				currentPage = regPage;
				currentPage.setVisible(true);
			}
		});
		
		//로그인 이벤트
		logBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = idField.getText();
				pwd = pwdField.getText();
				if(dao.login(id, pwd)) {
					JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
				currentUser = dao.currentUser(id);
					
					currentPage.setVisible(false);
					currentPage = mainPage;
					currentPage.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"아이디 또는 비밀번호가 틀립니다.");
				}
			}
		});
		
		//로그아웃 버튼
		JButton outBtn = new JButton("OUT");
		outBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPage.setVisible(false);
				currentPage = loginPage;
				currentPage.setVisible(true);
			}
		});
		
//main page	
		mainPage = new JPanel();
		mainPage.setBounds(0, 0, 1144, 491);
		mainPage.add(mainPanel);
		getContentPane().add(mainPage);
		mainPage.setVisible(false);
		mainPage.setLayout(null);
		
		
				
		//nautreBtn
				JButton natureBtn = new JButton("New button");
				natureBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = naturePage;
						currentPage.setVisible(true);
					}
				});
				natureBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\MainBtnNature.jpg"));
				natureBtn.setBounds(15, 85, 122, 47);
				mainPanel.add(natureBtn);
				natureBtn.setBorder(null);
				
				//expBtn
				JButton expBtn = new JButton("New button");
				expBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = expPage;
						currentPage.setVisible(true);
					}
				});
				expBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnExp.jpg"));
				expBtn.setBounds(12, 164, 135, 32);
				mainPanel.add(expBtn);
				expBtn.setBorder(null);
				
				
				//hisBtn
				JButton hisBtn = new JButton("New button");
				hisBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = hisPage;
						currentPage.setVisible(true);
					}
				});
				hisBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnHis.jpg"));
				hisBtn.setBounds(15, 218, 122, 38);
				mainPanel.add(hisBtn);
				hisBtn.setBorder(null);
								
				//bookmarkBtn
				JButton bookmarkBtn = new JButton("New button");
				bookmarkBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = bookmarkPage;
						currentPage.setVisible(true);
					}
				});
				bookmarkBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnBookmark.jpg"));
				bookmarkBtn.setBounds(7, 302, 143, 38);
				mainPanel.add(bookmarkBtn);
				bookmarkBtn.setBorder(null);
				
				//achieveBtn
				JButton achieveBtn = new JButton("New button");
				achieveBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = achievePage;
						currentPage.setVisible(true);
					}
				});
				achieveBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnAchieve.jpg"));
				achieveBtn.setBounds(15, 360, 122, 38);
				mainPanel.add(achieveBtn);
				achieveBtn.setBorder(null);
		
		//achievePage		
				achievePage = new JPanel();
				achievePage.setBounds(0, 0, 1144, 491);
				getContentPane().add(achievePage);
				achievePage.setLayout(null);
				achievePanel.setBounds(-3, 0, 1150, 491);
				achievePage.add(achievePanel);
				achievePage.setVisible(false);	
				
//achievePage button
				JButton achieve_expBtn = new JButton("New button");
				achieve_expBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = expPage;
						currentPage.setVisible(true);
					}
				});
				achieve_expBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnExp.jpg"));
				achieve_expBtn.setBorder(null);
				achieve_expBtn.setBounds(12, 164, 135, 32);
				achievePanel.add(achieve_expBtn);
				
				
				JButton achieve_hisBtn = new JButton("New button");
				achieve_hisBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = hisPage;
						currentPage.setVisible(true);
					}
				});
				achieve_hisBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnHis.jpg"));
				achieve_hisBtn.setBorder(null);
				achieve_hisBtn.setBounds(12, 216, 122, 38);
				achievePanel.add(achieve_hisBtn);
				
				JButton achieve_bookmarkBtn = new JButton("New button");
				achieve_bookmarkBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						list_1.setListData(dao.bookmarkInfo(currentUser));
						currentPage.setVisible(false);
						currentPage = bookmarkPage;
						currentPage.setVisible(true);
					}
				});
				achieve_bookmarkBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\mainBtnBookmark.jpg"));
				achieve_bookmarkBtn.setBorder(null);
				achieve_bookmarkBtn.setBounds(8, 302, 143, 38);
				achievePanel.add(achieve_bookmarkBtn);
				
				JButton achieve_natureBtn = new JButton("New button");
				achieve_natureBtn.setIcon(new ImageIcon("D:/505/WS2/Solo/Pimage\\MainBtnNature.jpg"));
				achieve_natureBtn.setBorder(null);
				achieve_natureBtn.setBounds(12, 84, 122, 47);
				achievePanel.add(achieve_natureBtn);
				
				JButton achieve_out = new JButton("OUT");
				achieve_out.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						currentPage.setVisible(false);
						currentPage = mainPage;
						currentPage.setVisible(true);
					}
				});
				achieve_out.setBounds(23, 446, 97, 32);
				achievePanel.add(achieve_out);
		outBtn.setBounds(25, 447, 97, 32);
		mainPanel.add(outBtn);
				
		setVisible(true);
	}
}
