M = eye(100);
M(1:101:end) = -2;
M(2:101:end) = 1;
M(101:101:end) = 1;

D = 1:100;
Y = sin(sqrt(2)*D); 
for p = 1:100
    c = 1/p;
    K = Y.*c;
    if p == 1
        N = K;
    else
        N = [N;K];
    end
end

A = M + N;

for p = 1:100
    c = 1/p;
    if p == 1
        b = c;
    else
        b = [b c];
    end
end

x = A.\b;
x(1:5)






