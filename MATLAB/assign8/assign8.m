k = 50;
x = linspace(-0.5, 0.5, 200);
y = linspace(-1, 1, 400);
[X, Y] = meshgrid(x, y);

j = besselj(0, k);
j1 = besselj(1, k);
g = @(r) cos(k*r)/k - ((cos(k) + sin(k)*1i)/(k*(j + j1*1i))) * besselj(0, k*r);
f = @(r) 0.15 .* (r<0.25) + g(r) .* (r>=0.25);

F = zeros(400, 200);
for i = 1:400
    for j = 1:200
        F(i,j) = f(sqrt(X(i,j)^2 + Y(i,j)^2));
    end
end

[U, S, V] = svd(F);
kv = [3, 9, 15, 21, 27];
fk = size(kv);
for i = 1:length(kv)
    k = kv(i);
    fk = U(:,1:k) * S(1:k,1:k) * V(:,1:k)';
end

plot(diag(S), 'b-');
title('Singular values of F');

figure();
subplot(2,3,1);
imagesc(x, y, real(F));
title('F');
for i = 1:length(kv)
    subplot(2,3,i+1);
    imagesc(x, y, real(fk));
    title(['F_', num2str(kv(i))]);
end