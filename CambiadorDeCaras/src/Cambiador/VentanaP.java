package Cambiador;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * @author LLAM6S
 */
public class VentanaP extends JFrame implements ActionListener,ListSelectionListener{
    public VentanaP(){
        super("Cambiador de Caras");
        this.setSize(700,800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        this.setVisible(true);
    }
        
    JList superior,media,baja;
    DefaultListModel modelo_d,modelo_s;
    String paths="./SUPERIOR";
    String pathm="./MEDIO";
    String pathi="./INFERIOR";
    String[] combo={"", "Combo 1", "Combo 2", "Combo 3"};
    JLabel texto,imagens,imagenm,imageni;
    JComboBox caja;
    JPanel panelizq,panelder,panel;
    Icon act;
    
    private void initComponents() {
        this.setLayout(new GridLayout(1,2));

//------------------------------------------------------------------------------//--------------------------------------------------------------------------------//
                                                                                // 
        panelizq = new JPanel(new GridLayout(3,1));                             // 
        panelizq.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));    // 
                                                                                //
//------------------------------------------------------------------//----------------------------------------------------------------------------------//
        panel = new JPanel(new BorderLayout());                     // 
        texto = new JLabel("Frente");                               // 
        panel.add(texto,BorderLayout.NORTH);                        // 
        superior = new JList();                                     //
        superior.addListSelectionListener(this);                    // 
        panel.add(new JScrollPane(superior),BorderLayout.CENTER);   // 
        panelizq.add(panel);                                        // 
        llenarListas(paths, superior);                              // 
        this.add(panelizq);                                         //                                       
//------------------------------------------------------------------//
        panel = new JPanel(new BorderLayout());                     //
        texto = new JLabel("Nariz");                                //
        panel.add(texto,BorderLayout.NORTH);                        //
        media = new JList();                                        //
        media.addListSelectionListener(this);                       //
        panel.add(new JScrollPane(media),BorderLayout.CENTER);      //
        panelizq.add(panel);                                        //
        llenarListas(pathm, media);                                 //
        this.add(panelizq);                                         //                                            //
//------------------------------------------------------------------//
        panel = new JPanel(new BorderLayout());                     //
        texto = new JLabel("Boca");                                 //
        panel.add(texto,BorderLayout.NORTH);                        //
        baja = new JList();                                         //
        baja.addListSelectionListener(this);                        //
        panel.add(new JScrollPane(baja),BorderLayout.CENTER);       //
        panelizq.add(panel);                                        //
        llenarListas(pathi,baja);                                   //
        this.add(panelizq);                                         //
//------------------------------------------------------------------//
        panel = new JPanel(null);
        panelder = new JPanel(new BorderLayout());
        panelder.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        caja = new JComboBox(combo);
        caja.addActionListener(this);
        panelder.add(caja, BorderLayout.NORTH);
        imagens = new JLabel(new ImageIcon("./SUPERIOR/Cristiano.png"));
        imagens.setBounds(0,70,340,205);
        superior.setSelectedValue("Cristiano.png", true);
        panel.add(imagens);
        imagenm = new JLabel(new ImageIcon("./MEDIO/Cristiano.png"));
        imagenm.setBounds(0,275,340,36);
        media.setSelectedValue("Cristiano.png", true);
        panel.add(imagenm);
        imageni = new JLabel(new ImageIcon("./INFERIOR/Cristiano.png"));
        imageni.setBounds(0,311,340,172);
        panel.add(imageni);
        baja.setSelectedValue("Cristiano.png", true);
        panelder.add(panel);
        this.add(panelder);
    }

    void llenarListas(String path, JList t){
        File DOC;
        modelo_d = new DefaultListModel();
        DOC = new File(path);
        String archivos[]=DOC.list();
        for (String t1 : archivos) {
            modelo_d.addElement(t1);
        }
        t.setModel(modelo_d);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
            if(caja.getSelectedItem().toString() == "Combo 1"){
                act = new ImageIcon(paths+"/Angelina.png");
                superior.setSelectedValue("Angelina.png", true);
                imagens.setIcon(act);
                act = new ImageIcon(pathm+"/Tom.png");
                media.setSelectedValue("Tom.png", true);
                imagenm.setIcon(act);
                act = new ImageIcon(pathi+"/Bean.png");
                baja.setSelectedValue("Bean.png", true);
                imageni.setIcon(act);
            }
            if(caja.getSelectedItem().toString() == "Combo 2"){
                act = new ImageIcon(paths+"/Cristiano.png");
                superior.setSelectedValue("Cristiano.png", true);
                imagens.setIcon(act);
                act = new ImageIcon(pathm+"/DonR.png");
                media.setSelectedValue("DonR.png", true);
                imagenm.setIcon(act);
                act = new ImageIcon(pathi+"/Angelina.png");
                baja.setSelectedValue("Angelina.png", true);
                imageni.setIcon(act);
            }
            if(caja.getSelectedItem().toString() == "Combo 3"){
                act = new ImageIcon(paths+"/Brad.png");
                superior.setSelectedValue("Brad.png", true);
                imagens.setIcon(act);
                act = new ImageIcon(pathm+"/Werever.png");
                media.setSelectedValue("Werever.png", true);
                imagenm.setIcon(act);
                act = new ImageIcon(pathi+"/Tom.png");
                baja.setSelectedValue("tom.png", true);
                imageni.setIcon(act);
            }
            
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {    
        if(lse.getSource()==superior){
                act = new ImageIcon(paths+"/"+superior.getSelectedValue().toString());
                imagens.setBounds(0,70,340,205);
                imagens.setIcon(act);
            }
            if(lse.getSource()==media){
                act = new ImageIcon(pathm+"/"+media.getSelectedValue().toString());
                imagenm.setBounds(0,275,340,36);
                imagenm.setIcon(act);

            }
            if(lse.getSource()==baja){
                act = new ImageIcon(pathi+"/"+baja.getSelectedValue().toString());
                imageni.setBounds(0,311,340,172);
                imageni.setIcon(act);
            }
            
    }
}
