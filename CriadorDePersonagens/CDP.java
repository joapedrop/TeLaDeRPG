package CriadorDePersonagens;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CDP extends JFrame {
     private ButtonGroup SelecionarDificuldade;
     private JRadioButton Facil;
     private JRadioButton Medio;
     private JRadioButton Dificil;
     private JComboBox<String> SelecionarClasse;
     private JCheckBox Magia;
     private JCheckBox Cura;
     private JCheckBox Furtividade;
     private JCheckBox Forca;
     private JSlider SelecionarNivelInicial;
     private JTextField NomeTxt;
     private JTextArea ResumoDoPersonagemTxt;
     private JButton CriarPersonagem;
     private JButton LimparCampos;
     private JPanel PainelEsquerdo;
     private JPanel PainelDireito;
     private JPanel PainelDificuldade;
     private JPanel PainelHabilidades;
     private JPanel PainelCriarELimpar;
     private JPanel PainelNome;
     private JPanel PainelClasse;

     public CDP() {
          setTitle("Criador de Personagens");
          setSize(700, 480);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setLayout(new GridLayout(1, 2, 10, 10));
          PainelEsquerdo = new JPanel();
          PainelEsquerdo.setLayout(new BoxLayout(PainelEsquerdo, BoxLayout.Y_AXIS));
          PainelEsquerdo.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

          PainelNome = new JPanel(new FlowLayout(FlowLayout.LEFT, 5 , 0));
          PainelNome.setAlignmentX(Component.LEFT_ALIGNMENT);
          JLabel Nome = new JLabel("Nome do Personagem:");
          NomeTxt = new JTextField(12);
          NomeTxt.setEditable(true);
          NomeTxt.setRequestFocusEnabled(true);
          PainelNome.add(Nome);
          PainelNome.add(NomeTxt);

          PainelClasse = new JPanel(new FlowLayout(FlowLayout.LEFT, 5 , 0));
          PainelClasse.setAlignmentX(Component.LEFT_ALIGNMENT);
          JLabel Classe = new JLabel("Classe: ");
          SelecionarClasse = new JComboBox<>();
          SelecionarClasse.addItem("Mago");
          SelecionarClasse.addItem("Bárbaro");
          SelecionarClasse.addItem("Ladrão");
          SelecionarClasse.addItem("Clerigo");
          PainelClasse.add(Classe);
          PainelClasse.add(SelecionarClasse);

          JLabel Dificulade = new JLabel("Nivel de dificulade:");
          Facil = new JRadioButton("Fácil");
          Medio = new JRadioButton("Médio");
          Dificil = new JRadioButton("Dificil");
          SelecionarDificuldade = new ButtonGroup();
          SelecionarDificuldade.add(Facil);
          SelecionarDificuldade.add(Medio);
          SelecionarDificuldade.add(Dificil);

          PainelDificuldade = new JPanel();
          PainelDificuldade.setLayout(new BoxLayout(PainelDificuldade, BoxLayout.Y_AXIS));
          PainelDificuldade.setAlignmentX(Component.LEFT_ALIGNMENT);
          PainelDificuldade.add(Facil);
          PainelDificuldade.add(Medio);
          PainelDificuldade.add(Dificil);

          JLabel Habilidade = new JLabel("Habilidades:");
          Habilidade.setAlignmentX(Component.LEFT_ALIGNMENT);
          Magia = new JCheckBox("Magia");
          Cura = new JCheckBox("Cura");
          Furtividade = new JCheckBox("Furtividade");
          Forca = new JCheckBox("Força");

          PainelHabilidades = new JPanel(new GridLayout(4, 1));
          PainelHabilidades.setAlignmentX(Component.LEFT_ALIGNMENT);
          PainelHabilidades.add(Magia);
          PainelHabilidades.add(Cura);
          PainelHabilidades.add(Furtividade);
          PainelHabilidades.add(Forca);

          JLabel NivelIincial = new JLabel("Nível inicial:");
          NivelIincial.setAlignmentX(Component.LEFT_ALIGNMENT);
          SelecionarNivelInicial = new JSlider(1, 10, 1);
          SelecionarNivelInicial.setMajorTickSpacing(1);
          SelecionarNivelInicial.setPaintTicks(true);
          SelecionarNivelInicial.setPaintLabels(true);
          SelecionarNivelInicial.setSnapToTicks(true);
          SelecionarNivelInicial.setAlignmentX(Component.LEFT_ALIGNMENT);
          JTextArea ValordoNivel = new JTextArea("" + SelecionarNivelInicial.getValue());

          SelecionarNivelInicial.addChangeListener(new ChangeListener() {

               @Override
               public void stateChanged(ChangeEvent e) {
                    ValordoNivel.setText("" + SelecionarNivelInicial.getValue());
               }

          });
          CriarPersonagem = new JButton("Criar Personagem");

          CriarPersonagem.addActionListener(e -> {

               String nome = NomeTxt.getText().trim();

               String dificuldade = "";
               if (Facil.isSelected()) {
                    dificuldade = "Fácil";
               }

               if (Medio.isSelected()) {
                    dificuldade = "Médio";
               }

               if (Dificil.isSelected()) {
                    dificuldade = "Dificil";
               }

               String classe = (String) SelecionarClasse.getSelectedItem();

               int nivel = SelecionarNivelInicial.getValue();

               String habilidade = "";
               if (Magia.isSelected()) {
                    habilidade += " Magia,";
               }

               if (Cura.isSelected()) {
                    habilidade += " Cura,";
               }

               if (Furtividade.isSelected()) {
                    habilidade += " Furtividade,";
               }

               if (Forca.isSelected()) {
                    habilidade += " Força,";
               }

               if (!habilidade.isEmpty()) {
                    habilidade = habilidade.substring(0, habilidade.length() - 1);
               } else {
                    habilidade = " Nenhuma";
               }

               String resumo = "☆FICHA DE PERSONAGEM☆\n"
                         + "------------------------\n"
                         + "Nome: " + nome + "\n"
                         + "Classe: " + classe + "\n"
                         + "Dificulade: " + dificuldade + "\n"
                         + "Habilidades:" + habilidade + "\n"
                         + "Nivel inicial: " + nivel + "\n"
                         + "------------------------\n";
               ResumoDoPersonagemTxt.append(resumo);

          });

          LimparCampos = new JButton("Limpar");
          LimparCampos.addActionListener(e -> {
               NomeTxt.setText("");
               SelecionarDificuldade.clearSelection();
               SelecionarClasse.setSelectedIndex(0);
               SelecionarNivelInicial.setValue(1);
               Magia.setSelected(false);
               Cura.setSelected(false);
               Furtividade.setSelected(false);
               Forca.setSelected(false);

          });
          PainelDireito = new JPanel(new BorderLayout());
          PainelDireito.setBorder(BorderFactory.createTitledBorder("Resumo do personagem"));

          ResumoDoPersonagemTxt = new JTextArea();
          ResumoDoPersonagemTxt.setLineWrap(true);
          ResumoDoPersonagemTxt.setWrapStyleWord(true);

          PainelDireito.add(new JScrollPane(ResumoDoPersonagemTxt), BorderLayout.CENTER);

          PainelCriarELimpar = new JPanel(new FlowLayout(FlowLayout.CENTER));
          PainelCriarELimpar.setAlignmentX(Component.LEFT_ALIGNMENT);
          PainelCriarELimpar.add(CriarPersonagem);
          PainelCriarELimpar.add(LimparCampos);

          PainelEsquerdo.add(PainelNome);
          PainelEsquerdo.add(Box.createVerticalStrut(5));
          PainelEsquerdo.add(PainelClasse);
          PainelEsquerdo.add(Box.createVerticalStrut(8));
          PainelEsquerdo.add(Dificulade);
          PainelEsquerdo.add(PainelDificuldade);
          PainelEsquerdo.add(Box.createVerticalStrut(8));
          PainelEsquerdo.add(Habilidade);
          PainelEsquerdo.add(PainelHabilidades);
          PainelEsquerdo.add(Box.createVerticalStrut(8));
          PainelEsquerdo.add(NivelIincial);
          PainelEsquerdo.add(SelecionarNivelInicial);
          PainelEsquerdo.add(Box.createVerticalStrut(10));
          PainelEsquerdo.add(PainelCriarELimpar);

          add(PainelEsquerdo);
          add(PainelDireito);

          setVisible(true);

     }

}