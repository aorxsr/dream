public class CCircle extends CPoint {

    private static final int CONSTANT_TWO = 2;

    /**
     * 圆心
     */
    private String centerPoint;
    /**
     * 半径
     */
    private double radius;

    /**
     * 无参构造器
     */
    public CCircle() {
    }

    /**
     * 有参构造器
     *
     * @param centerPoint 圆心(可以继续封装成坐标)
     * @param radius      半径
     */
    public CCircle(String centerPoint, double radius) {
        super();
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    /**
     * 获取圆心值
     *
     * @return 圆心值
     */
    private String getCenterPoint() {
        return centerPoint;
    }

    /**
     * 设置圆心值
     *
     * @param centerPoint
     */
    private void setCenterPoint(String centerPoint) {
        this.centerPoint = centerPoint;
    }

    /**
     * 获取圆半径
     *
     * @return
     */
    private double getRadius() {
        return radius;
    }

    /**
     * 设置圆半径
     *
     * @param radius
     */
    private void setRadius(long radius) {
        this.radius = radius;
    }

    /**
     * 计算圆周长
     *
     * @return
     */
    public double perimeter() {
        return Math.PI * this.radius * CONSTANT_TWO;
    }

    /**
     * 计算圆面积
     *
     * @return
     */
    public double area() {
        return Math.PI * this.radius * this.radius;
    }

}
