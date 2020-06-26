public class CCircleDemo {

    public static void main(String[] args) {
        String centerPoint = "yx";
        double radius = 10;

        CCircle circle = new CCircle(centerPoint, radius);
        System.out.println("圆心:" + centerPoint);
        System.out.println("半径:" + radius);

        double perimeter = circle.perimeter();
        System.out.println("周长：" + perimeter);

        double area = circle.area();
        System.out.println("面积为：" + area);
    }

}
