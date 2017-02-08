/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mnm.test;

import org.zkoss.zul.Label;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Row;
import org.zkoss.zul.RowRenderer;

/**
 *
 * @author mnm
 */
class LiveGroupRenderer implements RowRenderer {
		public void render(Row row, java.lang.Object data) {
			if(data instanceof String[]) {
				String[] ary = (String[]) data;
	            new Listcell(ary[6]).setParent(row);
                new Listcell(ary[5]).setParent(row);
                new Listcell(ary[4]).setParent(row);
                new Listcell(ary[3]).setParent(row);
                new Listcell(ary[2]).setParent(row);
                new Listcell(ary[1]).setParent(row);
	            new Listcell(ary[0]).setParent(row);

			} else {
				new Label(data.toString()).setParent(row);
			}

		}
	}
