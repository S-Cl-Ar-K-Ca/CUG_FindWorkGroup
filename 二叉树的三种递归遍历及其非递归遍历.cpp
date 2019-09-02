#include <iostream>
#include <random>
#include <vector>
#include <stack>
#include <iomanip>

using namespace std;

struct BTreeNode{
    BTreeNode(int data = 0):_data(data), plchild(nullptr),prchild(nullptr){}

    int _data;
    BTreeNode *plchild;
    BTreeNode *prchild;
};

BTreeNode* random_btree_generator( const int cnt = 10 ){
    default_random_engine dr_engine;
    uniform_int_distribution<> ui_dbtion(0,1000);

    BTreeNode *root = new BTreeNode();
    vector< BTreeNode* > vpbtn{ root };//�����������������ɵ�Ҷ�ӽڵ�ָ��
    for( int i = 0; i < cnt; ++i ){
        int rdom  = ui_dbtion(dr_engine); //����һ�������
        auto iter = vpbtn.begin()+ rdom % vpbtn.size();//���ָ��һ��Ҷ�ӽڵ�ָ��

        BTreeNode *pbtn   = *iter;        // lpbtn������������һ��Ҷ�ӽڵ�ָ��
        BTreeNode *pleft  = nullptr;
        BTreeNode *pright = nullptr;

        vpbtn.erase(iter);//�Ѿ��Ƿ�Ҷ�ӽڵ��ˣ���vector���Ƴ�

        switch( rdom % 3 ){
        case 0:
            pleft = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pleft );
            break;
        case 1:
            pright = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pright );
            break;
        case 2:
            pleft = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pleft );
            pright = new BTreeNode( ui_dbtion(dr_engine) );
            vpbtn.push_back( pright );
            break;
        default:;
        }
        pbtn->plchild = pleft;
        pbtn->prchild = pright;
    }
    return root;
}

void btree_destructor( BTreeNode *root ){
    if( root == nullptr )
        return ;
    btree_destructor( root->plchild );
    btree_destructor( root->prchild );
    delete root;
}

void display_traversal_result( vector<int> &tresult ){
    for( auto iter = tresult.begin(); iter != tresult.end(); ++iter ){
        cout << right << setw(4) << *iter << ' ';
        if( !((iter - tresult.begin() + 1) % 10) )
            cout << endl;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////
//�ݹ�     recursive
//�ǵݹ�   non-recursive
//ǰ����� preorder traversal
//ǰ������ݹ��㷨 ������������浽һ�� vector ��
void recursive_preorder_traversal(BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    result.push_back( root->_data );
    recursive_preorder_traversal(root->plchild, result);
    recursive_preorder_traversal(root->prchild, result);
    return;
}

//ǰ������ǵݹ��㷨
void non_recursive_preorder_traversal(BTreeNode *root, vector<int> &result ){
    BTreeNode *pbtn = root;
    stack<BTreeNode*> spbtn;
    while( pbtn != nullptr || !spbtn.empty() ){
        while( pbtn != nullptr ){
            result.push_back( pbtn->_data );
            spbtn.push( pbtn );
            pbtn = pbtn->plchild;

        }
        if( !spbtn.empty() ){
            pbtn = spbtn.top();
            spbtn.pop();
        }
        if( pbtn != nullptr )
            pbtn = pbtn->prchild;
    }
    return;
}

//��֤����
void dlr_test( BTreeNode *root ){
    vector< int > rresutt;
    vector< int > nrresult;

    cout << "ǰ��ݹ�����������:" << endl;
    recursive_preorder_traversal(root, rresutt);
    display_traversal_result( rresutt );

    cout <<"\n\nǰ��ǵݹ�����������:" << endl;
    non_recursive_preorder_traversal(root, nrresult);
    display_traversal_result(nrresult);

    cout << endl << endl;
    if( rresutt == nrresult ){
        cout << "�ݹ��㷨��ǵݹ��㷨�������һ����" << endl;
    }else {
        cout << "�ݹ��㷨��ǵݹ��㷨���������һ����" << endl;
    }
    return;
}


////////////////////////////////////////////////////////////////////////////////////////////
//�ݹ�     recursive
//�ǵݹ�   non-recursive
//������� inorder traversal
//��������ݹ��㷨��������������浽һ�� vector ��
void recursive_inorder_traversal( BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    recursive_inorder_traversal(root->plchild, result);
    result.push_back( root->_data );
    recursive_inorder_traversal(root->prchild, result);
}

//��������ǵݹ��㷨��������������浽һ�� vector ��
void non_recursive_inorder_traversal( BTreeNode *root, vector<int> &result ){
    BTreeNode *pbtn = root;
    stack<BTreeNode*> spbtn;
    while( pbtn != nullptr || !spbtn.empty() ){
        while( pbtn != nullptr ){
            spbtn.push( pbtn );
            pbtn = pbtn->plchild;
        }
        if( !spbtn.empty() ){
            pbtn = spbtn.top();
            spbtn.pop();
            result.push_back( pbtn->_data );
        }
        if( pbtn != nullptr )
            pbtn = pbtn->prchild;
    }
    return;
}

//��֤����
void ldr_test( BTreeNode *root ){
    vector< int > rresutt;
    vector< int > nrresult;

    cout << "����ݹ�����������:" << endl;
    recursive_inorder_traversal(root, rresutt);
    display_traversal_result( rresutt );

    cout <<"\n\n����ǵݹ�����������:" << endl;
    non_recursive_inorder_traversal(root, nrresult);
    display_traversal_result(nrresult);

    cout << endl << endl;
    if( rresutt == nrresult ){
        cout << "�ݹ��㷨��ǵݹ��㷨�������һ����" << endl;
    }else {
        cout << "�ݹ��㷨��ǵݹ��㷨���������һ����" << endl;
    }
    return;
}


////////////////////////////////////////////////////////////////////////////////////////////
//�ݹ�     recursive
//�ǵݹ�   non-recursive
//������� postorder traversal
//��������ݹ��㷨��������������浽һ�� vector ��
void recursive_postorder_traversal( BTreeNode *root, vector<int> &result ){
    if( root == nullptr )
        return;
    recursive_postorder_traversal( root->plchild, result);
    recursive_postorder_traversal( root->prchild, result);
    result.push_back( root->_data );
    return;
}

//��������ǵݹ��㷨��������������浽һ��vector ��
void non_recursive_postorder_traversal( BTreeNode *root, vector<int> &result ){
    BTreeNode *pbtn = root;
    stack<bool> visited;
    stack<BTreeNode*> spbtn;
    while( pbtn != nullptr || !spbtn.empty() ){
        while( pbtn != nullptr ){
            spbtn.push( pbtn );
            visited.push( false );
            pbtn = pbtn->plchild;
        }
        if( !spbtn.empty() ){
            bool first = visited.top();
            visited.pop();

            pbtn = spbtn.top();
            spbtn.pop();
            if( first ){
                result.push_back( pbtn->_data );
                pbtn = nullptr;
            }else{
                visited.push( true );
                spbtn.push( pbtn );
            }
        }
        if( pbtn != nullptr )
            pbtn = pbtn->prchild;
    }
    return;
}

//��֤����
void lrd_test( BTreeNode *root ){
    vector< int > rresutt;
    vector< int > nrresult;

    cout << "����ݹ�����������:" << endl;
    recursive_postorder_traversal(root, rresutt);
    display_traversal_result( rresutt );

    cout <<"\n\n����ǵݹ�����������:" << endl;
    non_recursive_postorder_traversal(root, nrresult);
    display_traversal_result(nrresult);

    cout << endl << endl;
    if( rresutt == nrresult ){
        cout << "�ݹ��㷨��ǵݹ��㷨�������һ����" << endl;
    }else {
        cout << "�ݹ��㷨��ǵݹ��㷨���������һ����" << endl;
    }
    return;
}


////////////////////////////////////////////////////////////////////////////////////////////
int main(){

    BTreeNode *root = random_btree_generator(500);

    dlr_test( root );//ǰ��
    cout << endl << endl << endl << endl;

    ldr_test( root );//����
    cout << endl << endl << endl << endl;

    lrd_test( root );//����
    cout << endl << endl << endl << endl;

    btree_destructor(root);
    return 0;
}
