% question 2
k = 10;
for r = 0:360
    u = (cos(k*r)/k)-((cos(k)+sin(k)*sqrt(-1))/(k*(besselj(0,k*r)+besselj(1,k)*sqrt(-1))))*(besselj(0,k*r));
    plot(r,real(u),'o',r,imag(u),'o')
    hold on
    xlabel('r')
    title('function u')
end