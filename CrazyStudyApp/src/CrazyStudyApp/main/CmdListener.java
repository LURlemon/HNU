package CrazyStudyApp.main;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

class CmdListener implements ItemListener
{
	String problemType;

	public void itemStateChanged(ItemEvent e)
	{
		problemType = e.getItem().toString();
		// System.out.println(str);
	}

	String getProblemType()
	{
		return problemType;
	}
}
