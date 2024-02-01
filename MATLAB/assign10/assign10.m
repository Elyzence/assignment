%%  Question 1
a=1/4;
b=4/5;
c=8/3;

ode=@(t,u)[t*u(1);u(3);u(2)*(t*u(1)-a*u(2)+b)^2-c*u(1)];
u0=[1;3.3;2];
[t,y]=ode45(ode,[0,1],u0);

subplot(3,1,1)
plot(t,y(:,1))
xlabel('time')
ylabel('u_1(t)')
grid on

subplot(3,1,2)
plot(t,y(:,2))
xlabel('time')
ylabel('u_2(t)')
grid on

subplot(3,1,3)
plot(t,y(:,3))
xlabel('time')
ylabel('u_2''(t)')
grid on


%% Question 2

xi = [1, 3, 6, 9, 11, 15];
yi = [1, 9, 35, 79, 120, 210];

x = 1:16;

n = length(xi) - 1;

L = @(x, xi, yi) sum(yi .* prod(bsxfun(@rdivide, bsxfun(@minus, x, xi([1:i-1 i+1:end])), xi(i) - xi([1:i-1 i+1:end])), 2));

y = zeros(size(x));
for i = 1:length(x)
    y(i) = L(x(i), xi, yi);
end

figure
hold on
plot(xi, yi, 'o')
plot(x, y)
xlabel('x')
ylabel('y')
title('Polynomial Interpolation')
legend('Data Points', 'Approximated Values')

