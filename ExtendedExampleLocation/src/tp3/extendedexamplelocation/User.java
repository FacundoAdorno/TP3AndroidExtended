package tp3.extendedexamplelocation;

public class User {

	private ContextFeature positionContext = new ContextFeature("position", null);

	public Object getPositionContextValue() {
		return positionContext.getValor();
	}

	public void setPositionContextValue(Object positionContext) {
		this.positionContext.setValor(positionContext);
	}
	
}