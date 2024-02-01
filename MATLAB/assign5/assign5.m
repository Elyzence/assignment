format long

x = myiqim(@f,0.7,0.8,0.9);

function sol = myiqim(F,x1,x2,x3)
  rat = 1;
  y1 = feval(F,x1);
  y2 = feval(F,x2);
  y3 = feval(F,x3);
  while rat > 1.0e-10
      c2 = ((x2-x3)/(y2-y3)-(x1-x3)/(y1-y3))/(y2-y1);
      c1 = ((x2-x3)/(y2-y3))-(y2-y3)*c2;
       dx = -c1*y3+c2*y3^2;
      dx = (x3-x2)/x2;
      x4 = x3 - dx;
      y4 = feval(F,x4);
      rat = abs(dx/x4);
      x1=x2;
      x2=x3;
      x3=x4;
      y1=y2;
      y2=y3;
      y3=y4;
  end
sol = x4;
end

function y=f(x)
    y = x.^7-cos(x);
end