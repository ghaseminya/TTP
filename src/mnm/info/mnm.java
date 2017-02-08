/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.info;
import com.lowagie.text.Row;
import java.util.ArrayList;
import org.zkoss.zul.AbstractTreeModel;
import java.util.List;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listfoot;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Panelchildren;
import org.zkoss.zul.RowRenderer;
import org.zkoss.zul.SimpleListModel;
import org.zkoss.zul.SimpleTreeNode;

/**
 *
 * @author mnm
 */
public class mnm {
public class BinaryTreeModel extends AbstractTreeModel{

    private ArrayList _tree =null;

    public BinaryTreeModel(List tree){
        super(tree.get(0));
        _tree = (ArrayList)tree;
    }

    public Object getChild(Object parent, int index) {
        int i = _tree.indexOf(parent) *2 +1 + index;
        if( i>= _tree.size())
            return null;
        else
            return _tree.get(i);
    }

    public int getChildCount(Object parent) {
        int count = 0;
        if(getChild(parent,0) != null)
            count++;
        if(getChild(parent,1) != null)
            count++;
        return count;
    }

    public boolean isLeaf(Object node) {
        return (getChildCount(node) == 0);
    }

}
public class BigList extends java.util.AbstractList {
    private int _sz;
    public BigList(int sz) {
        if (sz < 0)
            throw new IllegalArgumentException(
                "Negative not allowed: "+sz);
        _sz = sz;
    }
    public int size() {
        return _sz;
    }
    public Object get(int j) {
        return new Integer(j);
    }
}
	BinaryTreeModel btm = new BinaryTreeModel(new ArrayList(new BigList(1000)));

public void mn(){
//as.setRows(rows)
//        rows="10" width="350px" height="300px" fixedLayout="true" style="background:white;"

Listbox asda;

//asda.set();

}
}
