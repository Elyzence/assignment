theta = 0:0.001:2*pi; 
[x,y] = circle(2,theta);
subplot(1,2,1)
fill(x,y,'y')
axis equal off

r = 5;
m = 10000;
[x,y] = circle(r,theta);
p = rdcircle(x,y,m);
subplot(1,2,2) 
plot(real(p),imag(p),'b.','MarkerSize',1) 
axis equal off


function [x,y] = circle(r,theta)
        x = r*sin(theta);
        y = r*cos(theta);
end



function p = rdcircle(x, y, m)

    n = length(x);
    p = zeros(1,n);
    p1 = rand-1 + 1i*(rand-1);
    
    for j = 1:n
        k = randi([1,n]);
        z = exp(1)^(x(k) + y(k)*1i);
        p(j) = 0.5*p(j) + 0.5*(z - p(j));
    end

end

