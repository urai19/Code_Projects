function [receive]= vaccine(myVacData, numVac)
[row,col]=size(myVacData);
receive= zeros(1,col);
count=0;
for i=1:5
    for j=1:col
        if (myVacData(1,j)==i && myVacData(2,j)==0)
            if(count<numVac)
                receive(j)=1;
                count=count+1;
            end
        elseif (myVacData(1,j)==i && myVacData(2,j)==1 && myVacData(3,j)>21)
            if(count<numVac)
                receive(j)=1;
                count=count+1;
            end
        end
    end 
end

