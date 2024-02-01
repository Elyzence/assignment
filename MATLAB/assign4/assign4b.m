n = 10;
r = 1;
A = eye(10,3);
y = eye(10,1);
for j = 1:n
    x = 1+(j-1)/(n-1);
    A(r,1) = 1;
    A(r,2) = x;
    A(r,3) = x^2;

    t = exp(1)^x;
    y(r) = t;

    r = r+1;
end

c = A\y;
c1 = c(1);
c2 = c(2);
c3 = c(3);

c1
c2
c3