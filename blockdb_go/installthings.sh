git clone https://github.com/grpc/grpc-go.git $GOPATH/src/google.golang.org/grpc
git clone https://github.com/golang/net.git $GOPATH/src/golang.org/x/net
git clone https://github.com/golang/text.git $GOPATH/src/golang.org/x/text
git clone https://github.com/golang/protobuf.git $GOPATH/src/github.com/golang/protobuf
git clone https://github.com/google/go-genproto.git $GOPATH/src/google.golang.org/genproto
git clone https://github.com/golang/sys.git $GOPATH/src/golang.org/x/sys
cd $GOPATH/src/
go install google.golang.org/grpc