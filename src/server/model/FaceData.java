package server.model;

public class FaceData {
	
	// Eyebrow (Upper Face)
	private float raiseBrow;
	private float furrowBrow;
	
	// Smile (Lower face)
	
	private float smile;
	private float clench;
	private float smirkLeft;
	private float smirkRight;
	private float laugh;
	
	// Eye
	private boolean winkLeft;
	private boolean winkRight;
	private boolean lookLeft;
	private boolean lookRight;
	
	private boolean blink;
	public float getRaiseBrow() {
		return raiseBrow;
	}
	public void setRaiseBrow(float raiseBrow) {
		this.raiseBrow = raiseBrow;
	}
	public float getFurrowBrow() {
		return furrowBrow;
	}
	public void setFurrowBrow(float furrowBrow) {
		this.furrowBrow = furrowBrow;
	}
	public float getSmile() {
		return smile;
	}
	public void setSmile(float smile) {
		this.smile = smile;
	}
	public float getClench() {
		return clench;
	}
	public void setClench(float clench) {
		this.clench = clench;
	}
	public float getSmirkLeft() {
		return smirkLeft;
	}
	public void setSmirkLeft(float smirkLeft) {
		this.smirkLeft = smirkLeft;
	}
	public float getSmirkRight() {
		return smirkRight;
	}
	public void setSmirkRight(float smirkRight) {
		this.smirkRight = smirkRight;
	}
	public float getLaugh() {
		return laugh;
	}
	public void setLaugh(float laugh) {
		this.laugh = laugh;
	}
	public boolean isBlink() {
		return blink;
	}
	public void setBlink(boolean blink) {
		this.blink = blink;
	}
	public boolean isWinkLeft() {
		return winkLeft;
	}
	public void setWinkLeft(boolean winkLeft) {
		this.winkLeft = winkLeft;
	}
	public boolean isWinkRight() {
		return winkRight;
	}
	public void setWinkRight(boolean winkRight) {
		this.winkRight = winkRight;
	}
	public boolean isLookLeft() {
		return lookLeft;
	}
	public void setLookLeft(boolean lookLeft) {
		this.lookLeft = lookLeft;
	}
	public boolean isLookRight() {
		return lookRight;
	}
	public void setLookRight(boolean lookRight) {
		this.lookRight = lookRight;
	}
	
	
	
	

}
