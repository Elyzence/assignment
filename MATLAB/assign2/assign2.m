M = eye(100);
M(1:101:end) = 0;


aR = 3;
aC = 1;
bR = 99;
bC = 1;
bC2 = 99;
bR2 = 1;

for j = 197:-2:1
    if j > 3
        b = sqrt(j);
        M(bR,bC) = b;
        M(bR2,bC2) = b;

        bC = bC+1;
        bR2 = bR2+1;
        if j>5
            a = j/(1+j);
            M(aC,aR) = a;
            M(aR,aC) = a;
            
            aR = aR+1;
            aC = aC+1;
        end
    end
end

x = eig(M);
[V,D] = eig(M);
d1 = D(:,2);
d2 = D(:,3);
s = mink(x,3)
plot(d1,d2);



