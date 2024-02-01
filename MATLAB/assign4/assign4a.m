n = 300;
a = linspace(1,4,n);
for j = 1:n
    x = 1;
    tiny = 1.0e-10;
    rat = 1;
    while rat > tiny
          dx = (tan(x)+(a(j)*sin(x))/x)/(-(a(j)*sin(x))/x^2+(sec(x))^2+(a(j)*cos(x)/x));  
          x = x - dx;
          rat = abs(dx/x);
    end
    y(j) = x;
end
plot(a,y)

