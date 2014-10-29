package com.songmho.java;

public class TreeTest {
	
	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Tree t1=new NullTree();
		Tree t2=new BinTree(t1,1,t1);
		Tree t3=new BinTree(t1,2,t1);
		Tree t4=new BinTree(t2,3,t3);
		Tree t5=new BinTree(t4,5,t4);
		Tree t6=new BinTree(t5,6,t3);	//트리 초기화
		
		System.out.println(t5.toString());		//t4의 트리 출력
		
		int count=count(t6);
		System.out.println("t6's count : "+count);
		int sum=sum(t4);
		System.out.println("t4's sum : "+sum);
		int height=height(t4);
		System.out.println("t4's height : "+height);
		//System.out.println();
		List l1=preorder(t5);
		l1.print();
		List l2=inorder(t5);
		l2.print();
		List l3=postorder(t5);
		l3.print();
		
	}

	private static int count(Tree tree) {			//count 메소드
		// TODO 자동 생성된 메소드 스텁
		int count=0;								//반환에 사용할 변수
		
		if(tree.isBinTree()){						//입력 받은 Tree가 null이 아닐 때
			if(tree.left().isBinTree())				//왼쪽 트리가 null이 아니면 count 1증가, 왼쪽 트리로 count메소드 실행
				count=count+count(tree.left());
				count=count+1;						//value가 null이 아니면 count 1증가
			if(tree.right().isBinTree())			//오른쪽 트리가 null이 아니면 count 1증가, 오른쪽 트리로 count 메소드 실행
				count=count+count(tree.right());			
		}
		
		return count;			//count 반환
	}
	
	private static int sum(Tree tree){			//sum 메소드
		int sum=0;								//반환에 사용할 변수
			if(tree.isBinTree()){
				sum=sum+tree.value();	
				if(tree.left().isBinTree())
					sum=sum+sum(tree.left());
				if(tree.right().isBinTree())
					sum=sum+sum(tree.right());
			}
		
		return sum;				//sum 반환
	}
	
	private static int height(Tree tree){			//height 메소드
		int height=0;
		if(tree.isBinTree()){					//tree가 null이 아닐 때
			height=1+height((height(tree.left())>height(tree.right())?tree.left():tree.right()));	//tree.left()와 tree.right의 길이를 비교하여 큰 것과 1을 더함.
		}
		
		return height;		//height반환
	}
	
	
	
	private static List preorder(Tree tree) {			//value->left->right
		if (tree.isNull()) {							//tree가 null 일 경우
			return new NullList();
		}
		else {											//tree가 null이 아닐 경우
			List l = new Pair(tree.value(), new NullList());
			return l.concat( preorder(tree.left()) ).concat( preorder(tree.right()));
		}
			
	}
	
	private static List inorder(Tree tree){				//left->value->right
		if(tree.isNull()){								//tree가 null 일 경우
			return new NullList();
		}
		else{											//tree가 null이 아닐 경우
			List l=new NullList();
			return l.concat(inorder(tree.left())).concat(new Pair(tree.value(),new NullList())).concat(inorder(tree.right()));
		}
	}
	
	private static List postorder(Tree tree){			//left->right->value
		if(tree.isNull()){								//tree가 null 일 경우
			return new NullList();
		}
		else{											//tree가 null이 아닐 경우
			List l= new NullList();
			return l.concat(postorder(tree.left())).concat(postorder(tree.right())).concat(new Pair(tree.value(),new NullList()));			
		}
	}

	
	/*
	 * private static List _preorder(Tree tree){		//value->left->right
		List list = new NullList();							//출력할 리스트
		List listbuf = null;						//버퍼로 사용할 리스트
		listbuf=new Pair(tree.value(),new NullList());		//버퍼리스트 초기화
		list=list.concat(listbuf);					//버퍼와 리스트 합침
		
		if(tree.left().isBinTree()){				//트리의 왼쪽이 차있을 때
			List left=_preorder(tree.left());		//왼쪽 트리를 가지고 재귀함수
			list=list.concat(left);					//결과를 합침
		}
		
		if(tree.right().isBinTree()){				//트리의 오른쪽이 차있을 때
			List right=_preorder(tree.right());		//오른쪽 트리를 가지고 재귀함수
			list=list.concat(right);				//결과를 합침
		}

		return list;							//list반환
	}
	
	 * private static List _inorder(Tree tree){		//left->value->right
		List list = new NullList();				//출력할 리스트
		List listbuf = null;						//버퍼로 사용할 리스트
		
		if(tree.left().isBinTree()){				//트리의 왼쪽이 차있을 때
			List left=_inorder(tree.left());			//왼쪽 트리를 가지고 재귀함수
			list=list.concat(left);					//결과를 합침
		}
		
		listbuf=new Pair(tree.value(),new NullList());	//버퍼리스트 초기화
		list=list.concat(listbuf);						//버퍼와 리스트 합침
		
		
		if(tree.right().isBinTree()){				//트리의 오른쪽이 차있을 때
			List right=_inorder(tree.right());		//오른쪽 트리를 가지고 재귀함수
			list=list.concat(right);				//결과를 합침
		}

		return list;
	}
	
	private static List _postorder(Tree tree){	//left->right->value
		List list = new NullList();					//출력할 리스트
		List listbuf = null;						//버퍼로 사용할 리스트
		if(tree.left().isBinTree()){				//트리의 왼쪽이 차있을 때
			List left=_postorder(tree.left());		//왼쪽 트리를 가지고 재귀함수
			list=list.concat(left);					//결과를 합침
		}
		
		if(tree.right().isBinTree()){				//트리의 오른쪽이 차있을 때
			List right=_postorder(tree.right());		//오른쪽 트리를 가지고 재귀함수
			list=list.concat(right);				//결과를 합침
		}

		listbuf=new Pair(tree.value(),new NullList());	//버퍼리스트 초기화
		list=list.concat(listbuf);						//버퍼와 리스트 합침

		return list;
	}*/
}
