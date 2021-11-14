package Utilisateur;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import DAO.Information;
import jade.core.AID;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class UtilisateurAgent extends GuiAgent
{
	private UtilisateurGUI gui;

	@Override
	protected void setup()
	{
		gui = new UtilisateurGUI();
		gui.setUtilisateurAgent(this);
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour()
		{
			Integer i = 0;

			@Override
			public void action()
			{
				MessageTemplate messageTemplate = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.REQUEST),
						MessageTemplate.MatchOntology("utilisateur"));
				ACLMessage aclMessage = receive(messageTemplate);
				MessageTemplate messageTemplate1 = MessageTemplate.and(
						MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("resfin"));
				ACLMessage aclMessage1 = receive(messageTemplate1);
				if(aclMessage1 == null)
				{
					block();
					return;
				}
				
				String infos = aclMessage1.getUserDefinedParameter("infos");
				/*String brand = aclMessage1.getUserDefinedParameter("brand");
				/*String model = aclMessage1.getUserDefinedParameter("model");
				String type = aclMessage1.getUserDefinedParameter("type");
				String year = aclMessage1.getUserDefinedParameter("year");
				String engine_type = aclMessage1.getUserDefinedParameter("engine_type");
				 
				System.out.println("utilisateur : " + brand+model+type+year+engine_type);
				*/
				if(infos.equals("NotFound"))
				{
					gui.showNotFound();
				}
				else
				{
					/*Information info = new Information(brand,model,type,Integer.parseInt(year),engine_type);
					System.out.println("gui.showmessage () : " + info);
					gui.showMessage(info);*/
					
					gui.showMessage(infos);
				}
				
			}

		});

	}

	@Override
	public void onGuiEvent(GuiEvent ev)
	{
		
		System.out.println("ev.getype : " + ev.getType());
		switch (ev.getType())
		{
		case 1:
			String brand = (String) ev.getParameter(0);
			String type = (String) ev.getParameter(1);
			List<String> list = new ArrayList<String>();
			list.add(brand);
			list.add(type);
			System.out.println(brand + "      " + type);

			ACLMessage aclMessage = new ACLMessage(ACLMessage.REQUEST);
			aclMessage.addReceiver(new AID("intermediaire1", AID.ISLOCALNAME));
			try {
				aclMessage.setContentObject((Serializable) list);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// aclMessage.setContent(type);
			aclMessage.setOntology("intermed");
			send(aclMessage);
			break;

		}

	}
}