import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseHandler extends MouseAdapter {
    private Grid grid;

    public MouseHandler(Grid grid) {
        this.grid=grid;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX= e.getX();
        int mouseY=e.getY();
        int nodeX=mouseX/grid.getNodeWidth();
        int nodeY=mouseY/grid.getNodeHeight();
        Node node=grid.getNode(nodeX,nodeY);
        if (Main.barrier.isSelected()) {
            node.toggleWalkable();
        } else if(Main.setStart.isSelected()){
            node.setStart();
        } else if(Main.setEnd.isSelected()){
            node.setEnd();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int mouseX= e.getX();
        int mouseY=e.getY();
        int nodeX=mouseX/grid.getNodeWidth();
        int nodeY=mouseY/grid.getNodeHeight();
        Node node=grid.getNode(nodeX,nodeY);
        if (Main.barrier.isSelected()) {
            node.toggleWalkable();
        } else if(Main.setStart.isSelected()){
            node.setStart();
        } else if(Main.setEnd.isSelected()){
            node.setEnd();
        }
    }
}
