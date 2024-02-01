f = @(x) (cos(6*pi*x) + sin(7*pi*x)) .* exp(1).^(-pi*x.^2);

N = 4096;   
m = 2046;
L = 20;    
dx = 2*L/N;

x = linspace(-L, L-dx, N);
y = f(x);

Y = fftshift(fft(y)) * dx;

k = (-N/2:N/2-1) / (N*dx);

% Plot the results
subplot(2,1,1);
plot(x, y);
xlabel('x');
ylabel('f(x)');
title('Original function');

subplot(2,1,2);
plot(k, abs(Y));
xlabel('k');
ylabel('|G(k)|');
title('Fourier transform');

