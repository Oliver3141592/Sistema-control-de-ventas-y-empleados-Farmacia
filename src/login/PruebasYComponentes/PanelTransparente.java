package login.PruebasYComponentes;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class PanelTransparente extends JPanel {

    private float transparencia = 0.7f; // 70% visible, 30% transparente
    private Color colorFondo = new Color(0, 0, 0); // Negro por defecto

    public PanelTransparente() {
        setOpaque(false); // Muy importante
    }

    public void setTransparencia(float valor) {
        this.transparencia = valor;
        repaint();
    }

    public void setColorFondo(Color color) {
        this.colorFondo = color;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparencia));
        g2d.setColor(colorFondo);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
        super.paintComponent(g);
    }
}
