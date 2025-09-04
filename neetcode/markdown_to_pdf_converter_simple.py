#!/usr/bin/env python3
"""
DSA Notes Markdown to PDF Converter (Simplified)
===============================================
Converts Data Structures and Algorithms markdown notes to a professional PDF
"""

import os
import re
import markdown
from pathlib import Path
from datetime import datetime
import argparse


class DSANotesConverter:
    def __init__(self, base_path="/Users/harshsingh.io/Downloads/Dev/dsa_notes"):
        self.base_path = Path(base_path)
        self.output_path = self.base_path / "DSA_Notes_Complete.pdf"
        
        # Define the order based on the hierarchy from the image
        self.file_order = [
            # Data Structures
            ("ds/arrays.md", "Arrays"),
            ("ds/hashmaps.md", "Hash Maps"),
            ("ds/hashset.md", "Hash Sets"),
            ("patterns/two_pointers.md", "Two Pointers"),
            ("patterns/sliding_window.md", "Sliding Window"),
            ("ds/linkedlist.md", "Linked Lists"),
            ("ds/stack.md", "Stacks"),
            ("ds/priority_queue.md", "Priority Queue / Heaps"),
            ("ds/trees.md", "Trees"),
            ("ds/binary_search_tree.md", "Binary Search Trees"),
            ("ds/treemap.md", "Tree Map"),
            ("ds/treeset.md", "Tree Set"),
            ("ds/tries.md", "Tries"),
            ("ds/graph/graph.md", "Graphs"),
            
            # Algorithms
            ("algo/binary_search.md", "Binary Search"),
            ("algo/greedy_algorithm.md", "Greedy Algorithms"),
            
            # Advanced Patterns
            ("patterns/interval.md", "Interval Patterns"),
        ]
        
        # Simplified CSS styling
        self.css_style = """
        @page {
            size: A4;
            margin: 2cm;
            
            @top-center {
                content: "DSA Notes - Complete Reference";
                font-family: Arial, sans-serif;
                font-size: 10pt;
                color: #666;
                border-bottom: 1px solid #ccc;
                padding-bottom: 8px;
            }
            
            @bottom-center {
                content: "Page " counter(page);
                font-family: Arial, sans-serif;
                font-size: 10pt;
                color: #666;
            }
        }
        
        @page:first {
            @top-center { content: none; }
        }
        
        body {
            font-family: Arial, sans-serif;
            font-size: 11pt;
            line-height: 1.6;
            color: #333;
            background: white;
            margin: 0;
            padding: 0;
        }
        
        .title-page {
            text-align: center;
            padding: 8cm 0;
            page-break-after: always;
        }
        
        .title-page h1 {
            font-size: 48pt;
            font-weight: bold;
            color: #2563eb;
            margin-bottom: 1cm;
        }
        
        .title-page .subtitle {
            font-size: 18pt;
            color: #666;
            margin-bottom: 2cm;
        }
        
        .title-page .date {
            font-size: 14pt;
            color: #999;
        }
        
        .toc {
            page-break-after: always;
            margin-bottom: 2cm;
        }
        
        .toc h1 {
            font-size: 28pt;
            color: #2563eb;
            border-bottom: 3px solid #2563eb;
            padding-bottom: 10px;
            margin-bottom: 1cm;
        }
        
        .toc ul {
            list-style: none;
            padding: 0;
        }
        
        .toc li {
            margin: 8px 0;
            padding: 8px 0;
            border-bottom: 1px dotted #ccc;
        }
        
        .toc a {
            text-decoration: none;
            color: #333;
            font-weight: 500;
        }
        
        h1 {
            font-size: 24pt;
            font-weight: bold;
            color: #2563eb;
            margin: 1.5cm 0 0.8cm 0;
            padding: 15px 0;
            border-bottom: 3px solid #2563eb;
            page-break-before: always;
        }
        
        h1:first-child {
            page-break-before: auto;
        }
        
        h2 {
            font-size: 18pt;
            font-weight: bold;
            color: #333;
            margin: 1cm 0 0.5cm 0;
            padding: 10px 0;
            border-bottom: 2px solid #ccc;
        }
        
        h3 {
            font-size: 14pt;
            font-weight: bold;
            color: #555;
            margin: 0.8cm 0 0.4cm 0;
        }
        
        h4, h5, h6 {
            font-size: 12pt;
            font-weight: bold;
            color: #666;
            margin: 0.6cm 0 0.3cm 0;
        }
        
        p {
            margin: 0.4cm 0;
            text-align: justify;
        }
        
        strong, b {
            font-weight: bold;
            color: #333;
        }
        
        em, i {
            font-style: italic;
            color: #555;
        }
        
        pre {
            background: #f8f9fa;
            border: 1px solid #ddd;
            border-left: 4px solid #2563eb;
            border-radius: 4px;
            padding: 15px;
            margin: 0.8cm 0;
            overflow-x: auto;
            font-family: 'Courier New', monospace;
            font-size: 9pt;
            line-height: 1.4;
        }
        
        code {
            font-family: 'Courier New', monospace;
            background: #f1f5f9;
            padding: 2px 6px;
            border-radius: 3px;
            font-size: 9pt;
            color: #333;
        }
        
        pre code {
            background: none;
            padding: 0;
            border-radius: 0;
        }
        
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 0.8cm 0;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
        }
        
        th {
            background: #f8f9fa;
            color: #333;
            font-weight: bold;
            padding: 12px;
            text-align: left;
            border: 1px solid #ddd;
        }
        
        td {
            padding: 10px 12px;
            border: 1px solid #ddd;
            vertical-align: top;
        }
        
        tr:nth-child(even) {
            background: #f9f9f9;
        }
        
        ul, ol {
            margin: 0.4cm 0;
            padding-left: 1.2cm;
        }
        
        li {
            margin: 0.2cm 0;
        }
        
        .math {
            font-family: 'Times New Roman', serif;
            font-style: italic;
        }
        
        blockquote {
            border-left: 4px solid #10b981;
            background: #f0fdf4;
            padding: 15px 20px;
            margin: 0.8cm 0;
            border-radius: 0 6px 6px 0;
            font-style: italic;
        }
        
        hr {
            border: none;
            height: 2px;
            background: linear-gradient(to right, #2563eb, #10b981);
            margin: 1cm 0;
            border-radius: 1px;
        }
        
        .page-break {
            page-break-before: always;
        }
        """
    
    def setup_markdown_processor(self):
        """Setup markdown processor with extensions"""
        return markdown.Markdown(
            extensions=[
                'extra',
                'codehilite',
                'toc',
                'tables',
                'fenced_code'
            ],
            extension_configs={
                'codehilite': {
                    'css_class': 'highlight',
                    'use_pygments': False,
                    'noclasses': True
                },
                'toc': {
                    'permalink': False
                }
            }
        )
    
    def process_math_expressions(self, content):
        """Convert LaTeX math expressions to HTML"""
        # Convert inline math $...$ to HTML
        content = re.sub(
            r'\$([^$]+)\$',
            r'<span class="math">\1</span>',
            content
        )
        
        # Convert display math $$...$$ to HTML
        content = re.sub(
            r'\$\$([^$]+)\$\$',
            r'<div class="math" style="text-align: center; margin: 1em 0;">\1</div>',
            content
        )
        
        return content
    
    def read_markdown_file(self, file_path):
        """Read and return markdown file content"""
        try:
            full_path = self.base_path / file_path
            if full_path.exists():
                with open(full_path, 'r', encoding='utf-8') as f:
                    return f.read()
            else:
                print(f"Warning: File {file_path} not found")
                return None
        except Exception as e:
            print(f"Error reading {file_path}: {e}")
            return None
    
    def generate_title_page(self):
        """Generate the title page HTML"""
        return f"""
        <div class="title-page">
            <h1>Data Structures & Algorithms</h1>
            <div class="subtitle">Complete Reference Notes</div>
            <div class="date">Generated on {datetime.now().strftime('%B %d, %Y')}</div>
        </div>
        """
    
    def generate_table_of_contents(self):
        """Generate table of contents HTML"""
        toc_html = """
        <div class="toc">
            <h1>Table of Contents</h1>
            <ul>
        """
        
        for file_path, title in self.file_order:
            # Create anchor from title
            anchor = re.sub(r'[^\w\s-]', '', title).strip().replace(' ', '-').lower()
            toc_html += f'<li><a href="#{anchor}">{title}</a></li>\n'
        
        toc_html += """
            </ul>
        </div>
        """
        
        return toc_html
    
    def convert_to_pdf(self):
        """Main conversion function"""
        print("🚀 Starting DSA Notes PDF conversion...")
        
        # Setup markdown processor
        md = self.setup_markdown_processor()
        
        # Start HTML document
        html_content = f"""
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>DSA Notes - Complete Reference</title>
            <style>
            {self.css_style}
            </style>
        </head>
        <body>
        """
        
        # Add title page
        html_content += self.generate_title_page()
        
        # Add table of contents
        html_content += self.generate_table_of_contents()
        
        # Process each file in order
        for file_path, title in self.file_order:
            print(f"📄 Processing: {title}")
            
            content = self.read_markdown_file(file_path)
            if content:
                # Create anchor for TOC linking
                anchor = re.sub(r'[^\w\s-]', '', title).strip().replace(' ', '-').lower()
                
                # Process mathematical expressions
                content = self.process_math_expressions(content)
                
                # Convert markdown to HTML
                html = md.convert(content)
                
                # Add section with proper heading and anchor
                html_content += f"""
                <div class="page-break" id="{anchor}">
                    <h1>{title}</h1>
                    {html}
                </div>
                """
                
                # Reset markdown processor for next file
                md.reset()
        
        # Close HTML document
        html_content += """
        </body>
        </html>
        """
        
        # Generate PDF
        print("📋 Generating PDF...")
        try:
            from weasyprint import HTML
            
            # Generate PDF with minimal configuration
            html_doc = HTML(string=html_content)
            html_doc.write_pdf(str(self.output_path))
            
            print(f"✅ PDF generated successfully: {self.output_path}")
            print(f"📊 File size: {self.output_path.stat().st_size / (1024*1024):.2f} MB")
            
        except Exception as e:
            print(f"❌ Error generating PDF with weasyprint: {e}")
            
            # Fallback: Try using reportlab
            try:
                print("🔄 Trying alternative PDF generation with reportlab...")
                self.convert_with_reportlab(html_content)
                return True
            except Exception as e2:
                print(f"❌ Reportlab approach also failed: {e2}")
                
                # Last fallback: Save as HTML
                html_path = self.base_path / "DSA_Notes_Complete.html"
                with open(html_path, 'w', encoding='utf-8') as f:
                    f.write(html_content)
                print(f"📄 Saved as HTML instead: {html_path}")
                print("💡 You can convert this HTML to PDF using your browser (Ctrl+P -> Save as PDF)")
                return True
        
        return True
    
    def convert_with_reportlab(self, html_content):
        """Alternative PDF generation using reportlab"""
        try:
            from reportlab.lib.pagesizes import A4
            from reportlab.platypus import SimpleDocTemplate, Paragraph, Spacer
            from reportlab.lib.styles import getSampleStyleSheet, ParagraphStyle
            from reportlab.lib.units import inch
            from bs4 import BeautifulSoup
            import re
            
            # Parse HTML
            soup = BeautifulSoup(html_content, 'html.parser')
            
            # Create PDF
            doc = SimpleDocTemplate(str(self.output_path), pagesize=A4)
            styles = getSampleStyleSheet()
            story = []
            
            # Process content
            for element in soup.find_all(['h1', 'h2', 'h3', 'p', 'pre', 'ul', 'ol']):
                if element.name == 'h1':
                    story.append(Paragraph(element.get_text(), styles['Title']))
                elif element.name == 'h2':
                    story.append(Paragraph(element.get_text(), styles['Heading1']))
                elif element.name == 'h3':
                    story.append(Paragraph(element.get_text(), styles['Heading2']))
                elif element.name in ['p', 'pre']:
                    text = element.get_text()
                    if text.strip():
                        story.append(Paragraph(text, styles['Normal']))
                
                story.append(Spacer(1, 0.2*inch))
            
            doc.build(story)
            print(f"✅ PDF generated with reportlab: {self.output_path}")
            
        except ImportError:
            print("❌ reportlab not installed. Install with: pip install reportlab beautifulsoup4")
            raise


def main():
    """Main function with command line argument support"""
    parser = argparse.ArgumentParser(description='Convert DSA markdown notes to PDF')
    parser.add_argument(
        '--input', '-i',
        default="/Users/harshsingh.io/Downloads/Dev/dsa_notes",
        help='Input directory containing markdown files'
    )
    parser.add_argument(
        '--output', '-o',
        help='Output PDF file path (optional)'
    )
    
    args = parser.parse_args()
    
    # Create converter instance
    converter = DSANotesConverter(args.input)
    
    # Set custom output path if provided
    if args.output:
        converter.output_path = Path(args.output)
    
    # Convert to PDF
    success = converter.convert_to_pdf()
    
    if success:
        print(f"\n🎉 Conversion completed successfully!")
        print(f"📖 Your DSA notes are ready!")
    else:
        print(f"\n💥 Conversion failed. Please check the error messages above.")


if __name__ == "__main__":
    main()